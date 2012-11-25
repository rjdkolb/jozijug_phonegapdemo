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
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import org.openrap.jozijug.mgwtphonegap.client.activities.AboutActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.AboutPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.ShowCaseListActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIPlace;

import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TestPhoneGapActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TestPhoneGapPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.CompassFunctionalityVerfiedActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.VerifyCompassPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.carousel.CarouselActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.carousel.CarouselPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.elements.ElementsActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.elements.ElementsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.forms.FormsActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.forms.FormsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.GPSFunctionalityVerfiedActivity;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.VerifyGPSPlace;
import org.openrap.jozijug.mgwtphonegap.client.places.HomePlace;

/**
 * @author Daniel Kurka
 *
 */
public class PhoneActivityMapper implements ActivityMapper {

    private final ClientFactory clientFactory;

    public PhoneActivityMapper(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof HomePlace) {
            return new ShowCaseListActivity(clientFactory);
        }

        if (place instanceof UIPlace) {
            return new UIActivity(clientFactory);
        }

        if (place instanceof AboutPlace) {
            return new AboutActivity(clientFactory);
        }

        if (place instanceof TestPhoneGapPlace) {
            return new TestPhoneGapActivity(clientFactory);
        }



        if (place instanceof ElementsPlace) {
            return new ElementsActivity(clientFactory);
        }

        if (place instanceof FormsPlace) {
            return new FormsActivity(clientFactory);
        }







        if (place instanceof CarouselPlace) {
            return new CarouselActivity(clientFactory);
        }

        if (place instanceof VerifyGPSPlace) {
            return new GPSFunctionalityVerfiedActivity(clientFactory);
        }

        if (place instanceof VerifyCompassPlace) {
            return new CompassFunctionalityVerfiedActivity(clientFactory);
        }
        return new ShowCaseListActivity(clientFactory);
    }
}
