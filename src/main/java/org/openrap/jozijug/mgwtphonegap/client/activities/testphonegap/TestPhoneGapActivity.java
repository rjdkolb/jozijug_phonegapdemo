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
package org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap;

import com.google.gwt.core.shared.GWT;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.compass.CompassCallback;
import com.googlecode.gwtphonegap.client.compass.CompassError;
import com.googlecode.gwtphonegap.client.compass.CompassHeading;
import com.googlecode.gwtphonegap.client.compass.CompassWatcher;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

import org.openrap.jozijug.mgwtphonegap.client.activities.home.Topic;
import org.openrap.jozijug.mgwtphonegap.client.event.ActionEvent;
import org.openrap.jozijug.mgwtphonegap.client.event.ActionNames;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import org.openrap.jozijug.mgwtphonegap.client.ClientFactory;

/**
 * @author Daniel Kurka
 *
 */
public class TestPhoneGapActivity extends MGWTAbstractActivity {

    private final ClientFactory clientFactory;
    private List<Topic> animations;
    private CompassWatcher compassWatcher;

    /**
     *
     */
    public TestPhoneGapActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;

    }

    @Override
    public void start(AcceptsOneWidget panel, final EventBus eventBus) {
        TestPhoneGapView view = clientFactory.getAnimationView();

        clientFactory.watchHeading(new CompassCallback() {
            @Override
            public void onError(CompassError error) {
                GWT.log(error.toString());
            }

            @Override
            public void onSuccess(CompassHeading heading) {
                //TopicSelectedEvent.fire(eventBus, heading);
            }
        });

        view.setLeftButtonText("Home");
        view.setTitle("Animation");
        animations = createAnimations();
        view.setAnimations(animations);

        addHandlerRegistration(view.getBackButton().addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent event) {
                ActionEvent.fire(eventBus, ActionNames.BACK);

            }
        }));

        addHandlerRegistration(view.getCellSelectedHandler().addCellSelectedHandler(
                new CellSelectedHandler() {
            @Override
            public void onCellSelected(CellSelectedEvent event) {
                int index = event.getIndex();


                TopicSelectedEvent.fire(eventBus, animations.get(index));

            }
        }));

        panel.setWidget(view);

    }

    @Override
    public void onStop() {
        super.onStop();
        clientFactory.clearWatchHeading(compassWatcher);
    }

    /**
     * @return
     */
    private List<Topic> createAnimations() {
        ArrayList<Topic> list = new ArrayList<Topic>();

        list.add(new Topic("Verify Compass", 1));
        list.add(new Topic("Verify GPS", 2));
        return list;
    }
}
