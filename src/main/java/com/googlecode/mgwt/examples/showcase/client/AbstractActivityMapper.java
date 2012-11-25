/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.examples.showcase.client.activities.AboutPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.ShowCaseListActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.UIActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.UIPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.testphonegap.TestPhoneGapActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.testphonegap.TestPhoneGapPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.carousel.CarouselPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.compass.VerifyCompassPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.elements.ElementsPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.forms.FormsPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.gps.GPSFunctionalityVerfiedActivity;
import com.googlecode.mgwt.examples.showcase.client.activities.gps.VerifyGPSPlace;
import com.googlecode.mgwt.examples.showcase.client.places.HomePlace;

/**
 *
 * @author richard
 */
public class AbstractActivityMapper implements ActivityMapper {

    private final ClientFactory clientFactory;
    private GPSFunctionalityVerfiedActivity gpsFunctionalityVerfiedActiviy;

    public AbstractActivityMapper(ClientFactory clientFactory) {
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
            return getAnimationActicity();
        }
        if (place instanceof VerifyGPSPlace) {
            return getVerifyGPSActvity();
        }

        GWT.log("trying to get activity " + place.toString() + " but did not find anything");
        return new ShowCaseListActivity(clientFactory);
    }

    private GPSFunctionalityVerfiedActivity getVerifyGPSActvity() {
        if (gpsFunctionalityVerfiedActiviy != null) {
            gpsFunctionalityVerfiedActiviy = new GPSFunctionalityVerfiedActivity(clientFactory);
        }
        return gpsFunctionalityVerfiedActiviy;
    }
}
