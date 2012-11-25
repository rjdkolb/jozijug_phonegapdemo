package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.examples.showcase.client.activities.animation.AnimationPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.VerifyCompassPlace;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

public class TabletMainAnimationMapper implements AnimationMapper {

	@Override
	public Animation getAnimation(Place oldPlace, Place newPlace) {
		if (oldPlace == null) {
			return Animation.FADE;
		}

		// animation

		if (oldPlace instanceof VerifyCompassPlace && newPlace instanceof AnimationPlace) {
			return Animation.SLIDE_REVERSE;
		}

		

		//		if (oldPlace instanceof AnimationCubePlace && newPlace instanceof AnimationPlace) {
		//			return Animation.CUBE_REVERSE;
		//		}
		//
		//		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationCubePlace) {
		//			System.out.println("asdfasdf");
		//			return Animation.CUBE;
		//		}

		return Animation.SLIDE;
	}

}
