package com.avathartech.fastformfields.widgets.client.decimaltextfield;

import com.avathartech.fastformfields.widgets.DecimalTextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(DecimalTextField.class)
public class DecimalTextFieldConnector extends AbstractComponentConnector {

	private static final long serialVersionUID = -491559284787322054L;
	private boolean hasDot = false;
	
	public DecimalTextFieldConnector() {
		getWidget().addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (getWidget().getText().contains(".")) {
					hasDot = true;
				} else {
					hasDot = false;
				}
				if ('.' == event.getCharCode() && hasDot) {
					getWidget().cancelKey();
				} else if ('.' != event.getCharCode() && !Character.isDigit(event.getCharCode())) {
					getWidget().cancelKey();
				}
			}
		});
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(DecimalTextFieldWidget.class);
	}

	@Override
	public DecimalTextFieldWidget getWidget() {
		return (DecimalTextFieldWidget) super.getWidget();
	}

	@Override
	public DecimalTextFieldState getState() {
		return (DecimalTextFieldState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		final String text = getState().text;
		getWidget().setText(text);
	}

}

