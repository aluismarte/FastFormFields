package com.avathartech.fastformfields.widgets;

import com.avathartech.fastformfields.widgets.client.uppertextfield.UpperTextFieldState;
import com.vaadin.data.Property;
import com.vaadin.ui.TextField;

public class UpperTextField extends TextField {

	private static final long serialVersionUID = 1086426416506494961L;

	public UpperTextField() {
		setValue("");
	}

	public UpperTextField(String caption) {
		this();
		setCaption(caption);
	}

	public UpperTextField(@SuppressWarnings("rawtypes") Property dataSource) {
		setPropertyDataSource(dataSource);
	}

	public UpperTextField(String caption, @SuppressWarnings("rawtypes") Property dataSource) {
		this(dataSource);
		setCaption(caption);
	}

	public UpperTextField(String caption, String value) {
		setValue(value);
		setCaption(caption);
	}

	@Override
	public UpperTextFieldState getState() {
		return (UpperTextFieldState) super.getState();
	}
	
	@Override
	public String getValue() {
		return super.getValue();
	}

	@Override
	public void setValue(String value) {
		super.setValue(value.toUpperCase());
		getState().text = value.toUpperCase();
	}
	
}