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

import com.google.gwt.place.shared.Place;

import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TestPhoneGapPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.VerifyCompassPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.carousel.CarouselPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.elements.ElementsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.forms.FormsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.VerifyGPSPlace;
import org.openrap.jozijug.mgwtphonegap.client.places.HomePlace;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import org.openrap.jozijug.mgwtphonegap.client.activities.AboutPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIPlace;

/**
 * @author Daniel Kurka
 *
 */
public class PhoneAnimationMapper implements AnimationMapper {

    @Override
    public Animation getAnimation(Place oldPlace, Place newPlace) {

        if (oldPlace instanceof UIPlace && newPlace instanceof HomePlace) {
            return Animation.SLIDE_REVERSE;
        }

        if (oldPlace instanceof AboutPlace && newPlace instanceof HomePlace) {
            return Animation.SLIDE_UP_REVERSE;
        }

        if (oldPlace instanceof HomePlace && newPlace instanceof AboutPlace) {
            return Animation.SLIDE_UP;
        }

        if (oldPlace instanceof HomePlace && newPlace instanceof TestPhoneGapPlace) {
            return Animation.SLIDE;
        }

        if (oldPlace instanceof HomePlace && newPlace instanceof UIPlace) {
            return Animation.SLIDE;
        }

        if (oldPlace instanceof TestPhoneGapPlace && newPlace instanceof HomePlace) {
            return Animation.SLIDE_REVERSE;
        }



        if (oldPlace instanceof UIPlace && newPlace instanceof ElementsPlace) {
            return Animation.SLIDE;
        }

        if (oldPlace instanceof ElementsPlace && newPlace instanceof UIPlace) {
            return Animation.SLIDE_REVERSE;
        }

        if (oldPlace instanceof UIPlace && newPlace instanceof FormsPlace) {
            return Animation.SLIDE;
        }

        if (oldPlace instanceof FormsPlace && newPlace instanceof UIPlace) {
            return Animation.SLIDE_REVERSE;
        }








        if (oldPlace instanceof UIPlace && newPlace instanceof CarouselPlace) {
            return Animation.SLIDE;
        }

        if (oldPlace instanceof CarouselPlace && newPlace instanceof UIPlace) {
            return Animation.SLIDE_REVERSE;
        }



        // animation

        if (oldPlace instanceof VerifyCompassPlace && newPlace instanceof TestPhoneGapPlace) {
            return Animation.SLIDE_REVERSE;
        }
        if (oldPlace instanceof VerifyGPSPlace && newPlace instanceof TestPhoneGapPlace) {
            return Animation.SLIDE_REVERSE;
        }
        // if (oldPlace instanceof AnimationCubePlace && newPlace instanceof
        // TestPhoneGapPlace) {
        // return Animation.CUBE_REVERSE;
        // }
        //
        // if (oldPlace instanceof TestPhoneGapPlace && newPlace instanceof
        // AnimationCubePlace) {
        // return Animation.CUBE;
        // }


        return Animation.SLIDE;

    }
}
