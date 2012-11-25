package org.openrap.jozijug.mgwtphonegap.client;



import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import org.openrap.jozijug.mgwtphonegap.client.activities.AboutActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.AboutPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TestPhoneGapPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.VerifyCompassPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.carousel.CarouselActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.carousel.CarouselPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.CompassFunctionalityVerfiedActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.elements.ElementsActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.elements.ElementsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.forms.FormsActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.forms.FormsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.GPSFunctionalityVerfiedActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.VerifyGPSPlace;
import org.openrap.jozijug.mgwtphonegap.client.places.HomePlace;

public class TabletMainActivityMapper implements ActivityMapper {

    private final ClientFactory clientFactory;
    private Place lastPlace;
    private GPSFunctionalityVerfiedActivity gpsFunctionalityVerfiedActiviy;

    public TabletMainActivityMapper(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;

    }

    @Override
    public Activity getActivity(Place place) {
        Activity activity = getActivity(lastPlace, place);
        lastPlace = place;
        return activity;

    }
    private AboutActivity aboutActivity;

    private AboutActivity getAboutActivity() {
        if (aboutActivity == null) {
            aboutActivity = new AboutActivity(clientFactory);
        }

        return aboutActivity;
    }

    private GPSFunctionalityVerfiedActivity getVerifyGPSActvity() {
        if (gpsFunctionalityVerfiedActiviy != null) {
            gpsFunctionalityVerfiedActiviy = new GPSFunctionalityVerfiedActivity(clientFactory);
        }
        return gpsFunctionalityVerfiedActiviy;
    }

    private Activity getActivity(Place lastPlace, Place newPlace) {
        if (newPlace instanceof HomePlace) {
            return getAboutActivity();
        }

        if (newPlace instanceof AboutPlace) {
            return getAboutActivity();
        }

        if (newPlace instanceof UIPlace) {
            return getAboutActivity();
        }


//        if (newPlace instanceof ElementsPlace) {
//            return new ElementsActivity(clientFactory);
//        }
//
//        if (newPlace instanceof FormsPlace) {
//            return new FormsActivity(clientFactory);
//        }







        if (newPlace instanceof TestPhoneGapPlace) {
            return new AboutActivity(clientFactory);
        }


        if (newPlace instanceof CarouselPlace) {
            return new CarouselActivity(clientFactory);
        }
        if (newPlace instanceof VerifyGPSPlace) {
            return new GPSFunctionalityVerfiedActivity(clientFactory);
        }

        if (newPlace instanceof VerifyCompassPlace) {
            return new CompassFunctionalityVerfiedActivity(clientFactory);
        }

        return null;
    }
}
