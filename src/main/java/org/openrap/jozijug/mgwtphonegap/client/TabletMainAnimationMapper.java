package org.openrap.jozijug.mgwtphonegap.client;

import com.google.gwt.place.shared.Place;
import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TestPhoneGapPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.VerifyCompassPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.VerifyGPSDoneView;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

public class TabletMainAnimationMapper implements AnimationMapper {

    @Override
    public Animation getAnimation(Place oldPlace, Place newPlace) {
        if (oldPlace == null) {
            return Animation.FADE;
        }

        // animation

        if (oldPlace instanceof VerifyCompassPlace && newPlace instanceof TestPhoneGapPlace) {
            return Animation.SLIDE_REVERSE;
        }
        if (oldPlace instanceof VerifyGPSDoneView && newPlace instanceof TestPhoneGapPlace) {
            return Animation.SLIDE_REVERSE;
        }


        //		if (oldPlace instanceof AnimationCubePlace && newPlace instanceof TestPhoneGapPlace) {
        //			return Animation.CUBE_REVERSE;
        //		}
        //
        //		if (oldPlace instanceof TestPhoneGapPlace && newPlace instanceof AnimationCubePlace) {
        //			System.out.println("asdfasdf");
        //			return Animation.CUBE;
        //		}

        return Animation.SLIDE;
    }
}
