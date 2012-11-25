/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.examples.showcase.client.activities.gps;

import com.googlecode.mgwt.examples.showcase.client.activities.compass.*;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.compass.CompassWatcher;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationWatcher;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.examples.showcase.client.ClientFactory;
import com.googlecode.mgwt.examples.showcase.client.event.ActionEvent;
import com.googlecode.mgwt.examples.showcase.client.event.ActionNames;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

/**
 * @author Daniel Kurka
 *
 */
public class GPSFunctionalityVerfiedActivity extends MGWTAbstractActivity {

    private final ClientFactory clientFactory;
    private GeolocationWatcher watcher;

    /**
     *
     */
    public GPSFunctionalityVerfiedActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;

    }

    @Override
    public void start(AcceptsOneWidget panel, final EventBus eventBus) {
        VerifyGPSDoneView view = clientFactory.getVerifyGPSView();


        watcher = clientFactory.watchGPS(view);

        addHandlerRegistration(view.getBackButton().addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent event) {
                ActionEvent.fire(eventBus, ActionNames.ANIMATION_END);

            }
        }));

        panel.setWidget(view);

    }

    @Override
    public void onStop() {
        super.onStop();
        clientFactory.clearWatchGPS(watcher);
    }
}
