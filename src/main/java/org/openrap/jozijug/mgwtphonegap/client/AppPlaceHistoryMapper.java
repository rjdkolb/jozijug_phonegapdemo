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

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import org.openrap.jozijug.mgwtphonegap.client.activities.AboutPlace.AboutPlaceTokenizer;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIPlace.UIPlaceTokenizer;

import org.openrap.jozijug.mgwtphonegap.client.activities.compass.VerifyCompassPlace.VerifyCompassPlaceTokenizer;
import org.openrap.jozijug.mgwtphonegap.client.activities.carousel.CarouselPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.elements.ElementsPlace.ElementsPlaceTokenizer;
import org.openrap.jozijug.mgwtphonegap.client.activities.forms.FormsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.VerifyGPSPlace.VerifyGPSTokenizer;
import org.openrap.jozijug.mgwtphonegap.client.places.HomePlace.HomePlaceTokenizer;

/**
 * @author Daniel Kurka
 *
 */
@WithTokenizers({HomePlaceTokenizer.class, UIPlaceTokenizer.class, AboutPlaceTokenizer.class, VerifyCompassPlaceTokenizer.class,
    ElementsPlaceTokenizer.class, FormsPlace.Tokenizer.class,
    CarouselPlace.Tokenizer.class, VerifyGPSTokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
