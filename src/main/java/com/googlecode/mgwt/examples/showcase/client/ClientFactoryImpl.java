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

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.googlecode.mgwt.examples.showcase.client.activities.AboutView;
import com.googlecode.mgwt.examples.showcase.client.activities.AboutViewGwtImpl;
import com.googlecode.mgwt.examples.showcase.client.activities.ShowCaseListView;
import com.googlecode.mgwt.examples.showcase.client.activities.ShowCaseListViewGwtImpl;
import com.googlecode.mgwt.examples.showcase.client.activities.UIView;
import com.googlecode.mgwt.examples.showcase.client.activities.UIViewImpl;
import com.googlecode.mgwt.examples.showcase.client.activities.animation.AnimationView;
import com.googlecode.mgwt.examples.showcase.client.activities.animation.AnimationViewGwtImpl;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationDoneView;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.AnimationDoneViewGwtImpl;
import com.googlecode.mgwt.examples.showcase.client.activities.carousel.CarouselView;
import com.googlecode.mgwt.examples.showcase.client.activities.carousel.CarouselViewGwtImpl;
import com.googlecode.mgwt.examples.showcase.client.activities.elements.ElementsView;
import com.googlecode.mgwt.examples.showcase.client.activities.elements.ElementsViewImpl;
import com.googlecode.mgwt.examples.showcase.client.activities.forms.FormsView;
import com.googlecode.mgwt.examples.showcase.client.activities.forms.FormsViewGwtImpl;

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
	private AnimationView animationView;
	private AnimationDoneView animationDoneView;

	private ElementsView elementsView;


	private FormsViewGwtImpl formsView;
	private CarouselView carouselView;


	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();

		placeController = new PlaceController(eventBus);

		homeViewImpl = new ShowCaseListViewGwtImpl();
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
	public AnimationView getAnimationView() {
		if (animationView == null) {
			animationView = new AnimationViewGwtImpl();
		}
		return animationView;
	}

	@Override
	public AnimationDoneView getAnimationDoneView() {
		if (animationDoneView == null) {
			animationDoneView = new AnimationDoneViewGwtImpl();
		}
		return animationDoneView;
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


}
