/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.openrap.jozijug.mgwtphonegap.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;
import com.googlecode.gwtphonegap.client.compass.CompassCallback;
import com.googlecode.gwtphonegap.client.compass.CompassOptions;
import com.googlecode.gwtphonegap.client.compass.CompassWatcher;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationOptions;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationWatcher;
import org.openrap.jozijug.mgwtphonegap.client.activities.AboutView;
import org.openrap.jozijug.mgwtphonegap.client.activities.AboutViewGwtImpl;
import org.openrap.jozijug.mgwtphonegap.client.activities.ShowCaseListView;
import org.openrap.jozijug.mgwtphonegap.client.activities.ShowCaseListViewGwtImpl;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIView;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIViewImpl;

import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TestPhoneGapView;
import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TestPhoneGapViewGwtImpl;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.VerifyCompassDoneView;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.VerifyCompassViewGwtImpl;
import org.openrap.jozijug.mgwtphonegap.client.activities.carousel.CarouselView;
import org.openrap.jozijug.mgwtphonegap.client.activities.carousel.CarouselViewGwtImpl;
import org.openrap.jozijug.mgwtphonegap.client.activities.elements.ElementsView;
import org.openrap.jozijug.mgwtphonegap.client.activities.elements.ElementsViewImpl;
import org.openrap.jozijug.mgwtphonegap.client.activities.forms.FormsView;
import org.openrap.jozijug.mgwtphonegap.client.activities.forms.FormsViewGwtImpl;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.VerifyGPSDoneView;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.VerifyGPSViewGwtImpl;

/**
 * @author Daniel Kurka
 *
 */
public class ClientFactoryImpl implements ClientFactory {

    private EventBus eventBus;
    private PlaceController placeController;
    private ShowCaseListView homeViewImpl;
    private UIView uiView;
    private AboutView aboutView;
    private TestPhoneGapView animationView;
    private VerifyCompassDoneView verifyCompassDoneView;
    private ElementsView elementsView;
    private FormsViewGwtImpl formsView;
    private CarouselView carouselView;
    final PhoneGap phoneGap;
    private VerifyGPSViewGwtImpl verifyGPSDoneView;

    public ClientFactoryImpl() {
        eventBus = new SimpleEventBus();

        placeController = new PlaceController(eventBus);

        homeViewImpl = new ShowCaseListViewGwtImpl();

        GWT.log("About to create Phonegap");
        phoneGap = GWT.create(PhoneGap.class);

        phoneGap.addHandler(new PhoneGapAvailableHandler() {
            @Override
            public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
                GWT.log("Success, phonegap loaded");
                //startShowCase(phoneGap);

            }
        });

        phoneGap.addHandler(new PhoneGapTimeoutHandler() {
            @Override
            public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
                Window.alert("can not load phonegap " + event.toDebugString());

            }
        });

        phoneGap.initializePhoneGap();

    }

    @Override
    public ShowCaseListView getHomeView() {
        if (homeViewImpl == null) {
            homeViewImpl = new ShowCaseListViewGwtImpl();
        }
        return homeViewImpl;
    }

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    @Override
    public UIView getUIView() {
        if (uiView == null) {
            uiView = new UIViewImpl();
        }
        return uiView;
    }

    @Override
    public AboutView getAboutView() {
        if (aboutView == null) {
            aboutView = new AboutViewGwtImpl();
        }

        return aboutView;
    }

    @Override
    public TestPhoneGapView getAnimationView() {
        if (animationView == null) {
            animationView = new TestPhoneGapViewGwtImpl();
        }
        return animationView;
    }

    @Override
    public VerifyCompassDoneView getVerifyCompassDoneView() {
        if (verifyCompassDoneView == null) {
            verifyCompassDoneView = new VerifyCompassViewGwtImpl();
        }
        return verifyCompassDoneView;
    }

    @Override
    public ElementsView getElementsView() {
        if (elementsView == null) {
            elementsView = new ElementsViewImpl();
        }
        return elementsView;
    }

    @Override
    public FormsView getFormsView() {
        if (formsView == null) {
            formsView = new FormsViewGwtImpl();
        }
        return formsView;
    }

    @Override
    public CarouselView getCarouselHorizontalView() {
        if (carouselView == null) {
            carouselView = new CarouselViewGwtImpl();
        }
        return carouselView;
    }

    @Override
    public VerifyGPSDoneView getVerifyGPSView() {
        if (verifyGPSDoneView == null) {
            verifyGPSDoneView = new VerifyGPSViewGwtImpl();
        }
        return verifyGPSDoneView;
    }

    //--------------------
    @Override
    public CompassWatcher watchHeading(CompassCallback callBack) {
        return phoneGap.getCompass().watchHeading(new CompassOptions(), callBack);
    }

    @Override
    public void clearWatchHeading(CompassWatcher watcher) {
        if (watcher == null) {
            return;
        }
        phoneGap.getCompass().clearWatcher(watcher);
    }
    //--------------------

    @Override
    public GeolocationWatcher watchGPS(GeolocationCallback callBack) {
        return phoneGap.getGeolocation().watchPosition(new GeolocationOptions(), callBack);
    }

    @Override
    public void clearWatchGPS(GeolocationWatcher watcher) {
        if (watcher == null) {
            return;
        }
        phoneGap.getGeolocation().clearWatch(watcher);
    }
}
