package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.examples.showcase.client.activities.AboutActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.AboutPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.UIPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animation.AnimationPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.compass.CompassFunctionalityVerfiedActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.compass.VerifyCompassPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.carousel.CarouselActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.carousel.CarouselPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.elements.ElementsActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.elements.ElementsPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.forms.FormsActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.forms.FormsPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.gps.GPSFunctionalityVerfiedActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.gps.VerifyGPSPlace;
import com.googlecode.mgwt.examples.showcase.client.places.HomePlace;

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


        if (newPlace instanceof ElementsPlace) {
            return new ElementsActivity(clientFactory);
        }

        if (newPlace instanceof FormsPlace) {
            return new FormsActivity(clientFactory);
        }







        if (newPlace instanceof AnimationPlace) {
            return new AboutActivity(clientFactory);
        }


        if (newPlace instanceof CarouselPlace) {
            return new CarouselActivity(clientFactory);
        }
        if (newPlace instanceof VerifyGPSPlace) {
            return new GPSFunctionalityVerfiedActivity(clientFactory);
        }

        if (newPlace instanceof VerifyCompassPlace) {
            return new GPSFunctionalityVerfiedActivity(clientFactory);
        }

        return null;
    }
}
