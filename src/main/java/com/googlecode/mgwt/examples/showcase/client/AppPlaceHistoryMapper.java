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
package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.googlecode.mgwt.examples.showcase.client.activities.AboutPlace.AboutPlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.UIPlace.UIPlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.animation.AnimationPlace.AnimationPlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationCubePlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationDissolvePlace.AnimationDissolvePlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationFadePlace.AnimationFadePlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationFlipPlace.AnimationFlipPlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationPopPlace.AnimationPopPlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationSlidePlace.AnimationSlidePlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationSlideUpPlace.AnimationSlideUpPlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationSwapPlace.AnimationSwapPlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.carousel.CarouselPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.elements.ElementsPlace.ElementsPlaceTokenizer;
import com.googlecode.mgwt.examples.showcase.client.activities.forms.FormsPlace;
import com.googlecode.mgwt.examples.showcase.client.places.HomePlace.HomePlaceTokenizer;

/**
 * @author Daniel Kurka
 * 
 */
@WithTokenizers({ HomePlaceTokenizer.class, UIPlaceTokenizer.class,  AboutPlaceTokenizer.class,  AnimationDissolvePlaceTokenizer.class,
		AnimationFadePlaceTokenizer.class, AnimationFlipPlaceTokenizer.class, AnimationPlaceTokenizer.class, AnimationPopPlaceTokenizer.class, AnimationSlidePlaceTokenizer.class,
		AnimationSlideUpPlaceTokenizer.class, AnimationSwapPlaceTokenizer.class, ElementsPlaceTokenizer.class, FormsPlace.Tokenizer.class,
		  AnimationCubePlace.Tokenizer.class,
		CarouselPlace.Tokenizer.class,  })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
