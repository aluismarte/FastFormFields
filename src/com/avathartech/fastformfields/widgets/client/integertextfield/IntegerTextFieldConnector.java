package com.avathartech.fastformfields.widgets.client.integertextfield;

import com.avathartech.fastformfields.widgets.IntegerTextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;

@Connect(IntegerTextField.class)
public class IntegerTextFieldConnector extends TextFieldConnector {

	private static final long serialVersionUID = -8997123500147616264L;

	public IntegerTextFieldConnector() {
		getWidget().addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (!Character.isDigit(event.getCharCode())) {
					getWidget().cancelKey();
				}
			}
		});
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(IntegerTextFieldWidget.class);
	}

	@Override
	public IntegerTextFieldWidget getWidget() {
		return (IntegerTextFieldWidget) super.getWidget();
	}

	@Override
	public IntegerTextFieldState getState() {
		return (IntegerTextFieldState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		final String text = getState().text;
		getWidget().setText(text);
	}

}
