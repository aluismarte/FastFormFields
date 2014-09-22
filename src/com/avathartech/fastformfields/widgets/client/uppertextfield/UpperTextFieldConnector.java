package com.avathartech.fastformfields.widgets.client.uppertextfield;

import com.avathartech.fastformfields.widgets.UpperTextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;

@Connect(UpperTextField.class)
public class UpperTextFieldConnector extends TextFieldConnector {

	private static final long serialVersionUID = -3793132878992127242L;
	
	private KeyUpHandler keyChecker;
	
	public UpperTextFieldConnector() {
		keyChecker = new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				
			}
		};
		
		getWidget().addKeyUpHandler(keyChecker);
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(UpperTextFieldWidget.class);
	}

	@Override
	public UpperTextFieldWidget getWidget() {
		return (UpperTextFieldWidget) super.getWidget();
	}

	@Override
	public UpperTextFieldState getState() {
		return (UpperTextFieldState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		String text = getWidget().getValue();
		text += getState().text;
		text.toUpperCase();
		getState().text = text;
		getWidget().setText(text);
	}
}
