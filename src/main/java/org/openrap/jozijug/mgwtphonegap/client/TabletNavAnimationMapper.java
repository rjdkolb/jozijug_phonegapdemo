package org.openrap.jozijug.mgwtphonegap.client;

import com.google.gwt.place.shared.Place;

import org.openrap.jozijug.mgwtphonegap.client.places.HomePlace;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIPlace;

public class TabletNavAnimationMapper implements AnimationMapper {

    @Override
    public Animation getAnimation(Place oldPlace, Place newPlace) {
        if (oldPlace == null) {
            return Animation.FADE;
        }

        if (oldPlace instanceof HomePlace && newPlace instanceof UIPlace) {
            return Animation.SLIDE;
        }

        if (oldPlace instanceof UIPlace && newPlace instanceof HomePlace) {
            return Animation.SLIDE_REVERSE;
        }

        return Animation.SLIDE;
    }
}
