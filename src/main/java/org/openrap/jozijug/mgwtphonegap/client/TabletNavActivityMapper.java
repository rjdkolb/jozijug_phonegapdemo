package org.openrap.jozijug.mgwtphonegap.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;

import org.openrap.jozijug.mgwtphonegap.client.activities.AboutPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.ShowCaseListActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TestPhoneGapActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TestPhoneGapPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.VerifyCompassPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.carousel.CarouselPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.CompassFunctionalityVerfiedActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.elements.ElementsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.forms.FormsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.GPSFunctionalityVerfiedActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.VerifyGPSPlace;
import org.openrap.jozijug.mgwtphonegap.client.places.HomePlace;

public class TabletNavActivityMapper implements ActivityMapper {

    private final ClientFactory clientFactory;
    private GPSFunctionalityVerfiedActivity gpsFunctionalityVerfiedActiviy;
    private CompassFunctionalityVerfiedActivity compassFunctionalityVerfiedActivity;

    public TabletNavActivityMapper(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
    private UIActivity uiActivity;
    private ShowCaseListActivity showCaseListActivity;
    private TestPhoneGapActivity animationActivity;

    private Activity getUIActivity() {
        if (uiActivity == null) {
            uiActivity = new UIActivity(clientFactory);
        }
        return uiActivity;
    }

    private Activity getShowCaseListActivity() {
        if (showCaseListActivity == null) {
            showCaseListActivity = new ShowCaseListActivity(clientFactory);
        }
        return showCaseListActivity;
    }

    private Activity getAnimationActicity() {
        if (animationActivity == null) {
            animationActivity = new TestPhoneGapActivity(clientFactory);
        }
        return animationActivity;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof HomePlace || place instanceof AboutPlace) {
            return getShowCaseListActivity();
        }

        if (place instanceof CarouselPlace || place instanceof UIPlace
                || place instanceof ElementsPlace || place instanceof FormsPlace) {
            return getUIActivity();
        }

        if (place instanceof TestPhoneGapPlace) {
            return getAnimationActicity();
        }

        if (place instanceof VerifyCompassPlace) {
            return getCompassActivity();
        }
        if (place instanceof VerifyGPSPlace) {
            return getVerifyGPSActvity();
        }

        GWT.log("trying to get activity " + place.toString() + " but did not find anything");
        return new ShowCaseListActivity(clientFactory);
    }

    private GPSFunctionalityVerfiedActivity getVerifyGPSActvity() {
        if (gpsFunctionalityVerfiedActiviy == null) {
            gpsFunctionalityVerfiedActiviy = new GPSFunctionalityVerfiedActivity(clientFactory);
        }
        return gpsFunctionalityVerfiedActiviy;
    }

    private Activity getCompassActivity() {
        if (compassFunctionalityVerfiedActivity == null) {
            compassFunctionalityVerfiedActivity = new CompassFunctionalityVerfiedActivity(clientFactory);
        }
        return compassFunctionalityVerfiedActivity;


    }
}
