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
package com.googlecode.mgwt.examples.showcase.client.activities.animationdone;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.compass.CompassError;
import com.googlecode.gwtphonegap.client.compass.CompassHeading;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;

/**
 * @author Daniel Kurka
 * 
 */
public class VerifyPhoneGapDoneViewGwtImpl implements VerifyPhoneGapDoneView {

	private RoundPanel panel;
	private Button button;
        Label compassLabel = new Label();
	/**
	 * 
	 */
	public VerifyPhoneGapDoneViewGwtImpl() {
		panel = new RoundPanel();
		panel.getElement().setAttribute("style", "text-align:center");
		panel.setHeight("200px");

		

		panel.add(compassLabel);

		button = new Button();
		button.getElement().setAttribute("style", "margin:auto;width: 200px; top: 125px; position:relative;");
		button.setText("Back");

		panel.add(button);

	}

	@Override
	public Widget asWidget() {
		return panel;
	}

	@Override
	public HasTapHandlers getBackButton() {
		return button;
	}

    @Override
    public void onError(CompassError error) {
        compassLabel.setText("Error "+error.toString());
    }

    @Override
    public void onSuccess(CompassHeading heading) {
        compassLabel.setText("Success "+heading.getTimeStamp() + " "+heading.getMagneticHeading());
    }

}
