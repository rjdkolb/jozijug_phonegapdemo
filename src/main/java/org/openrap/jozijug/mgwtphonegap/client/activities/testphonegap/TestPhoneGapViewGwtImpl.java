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
package org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap;

import java.util.List;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.compass.CompassError;
import com.googlecode.gwtphonegap.client.compass.CompassHeading;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

import org.openrap.jozijug.mgwtphonegap.client.activities.home.Topic;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import org.openrap.jozijug.mgwtphonegap.client.BasicCell;

/**
 * @author Daniel Kurka
 *
 */
public class TestPhoneGapViewGwtImpl implements TestPhoneGapView {

    private CellListWithHeader<Topic> list;
    private LayoutPanel main;
    private HeaderPanel headerPanel;
    private HeaderButton headerBackButton;
    private Label compass = new Label("Compass");

    /**
     *
     */
    public TestPhoneGapViewGwtImpl() {
        main = new LayoutPanel();

        headerPanel = new HeaderPanel();

        headerBackButton = new HeaderButton();

        headerPanel.setLeftWidget(headerBackButton);
        headerBackButton.setBackButton(true);
        headerBackButton.setVisible(!MGWT.getOsDetection().isAndroid());

        main.add(headerPanel);

        main.add(compass);

        ScrollPanel scrollPanel = new ScrollPanel();

        list = new CellListWithHeader<Topic>(new BasicCell<Topic>() {
            @Override
            public String getDisplayString(Topic model) {
                return model.getName();
            }

            @Override
            public boolean canBeSelected(Topic model) {
                return true;
            }
        });

        list.getCellList().setRound(true);

        scrollPanel.setWidget(list);
        scrollPanel.setScrollingEnabledX(false);

        main.add(scrollPanel);

    }

    @Override
    public Widget asWidget() {
        return main;
    }

    @Override
    public void setTitle(String text) {
        headerPanel.setCenter(text);

    }

    @Override
    public HasTapHandlers getBackButton() {
        return headerBackButton;
    }

    @Override
    public HasCellSelectedHandler getCellSelectedHandler() {
        return list.getCellList();
    }

    @Override
    public void setLeftButtonText(String text) {
        headerBackButton.setText(text);

    }

    @Override
    public void setAnimations(List<Topic> animations) {
        list.getCellList().render(animations);

    }

    @Override
    public HasText getFirstHeader() {
        return list.getHeader();
    }

    @Override
    public void onError(CompassError error) {
        compass.setText("Compass Error " + error.toString());
    }

    @Override
    public void onSuccess(CompassHeading heading) {
        compass.setText("Compass Success " + heading.toString());
    }
}
