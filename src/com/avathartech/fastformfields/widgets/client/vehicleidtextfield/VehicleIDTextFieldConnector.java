package com.avathartech.fastformfields.widgets.client.vehicleidtextfield;

import com.avathartech.fastformfields.widgets.VehicleIDTextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;

@Connect(VehicleIDTextField.class)
public class VehicleIDTextFieldConnector extends TextFieldConnector {

	private static final long serialVersionUID = 4362184367128516660L;
	
	int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 2, 3, 4, 5, 0, 7, 0, 9, 2, 3, 4, 5, 6, 7, 8, 9 };
    int[] weights = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };
	
	public VehicleIDTextFieldConnector() {
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(VehicleIDTextFieldWidget.class);
	}

	@Override
	public VehicleIDTextFieldWidget getWidget() {
		return (VehicleIDTextFieldWidget) super.getWidget();
	}

	@Override
	public VehicleIDTextFieldState getState() {
		return (VehicleIDTextFieldState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		final String text = getState().text;
		getWidget().setText(text);
	}
	

}

