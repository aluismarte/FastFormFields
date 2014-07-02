package com.avathartech.fastformfields.widgets.client.uppertextfield;

import com.vaadin.client.ui.VTextField;

public class UpperTextFieldWidget extends VTextField {

	public static final String CLASSNAME = "uppertextfield";

	public UpperTextFieldWidget() {
		setStyleName(CLASSNAME);
	}
	
	@Override
	public void setValue(String value) {
		super.setValue(value.toUpperCase());
	}

}