package com.avathartech.fastformfields.widgets;

import com.avathartech.fastformfields.widgets.client.integertextfield.IntegerTextFieldState;
import com.vaadin.data.Property;
import com.vaadin.ui.TextField;

public class IntegerTextField extends TextField {

	private static final long serialVersionUID = 7069173392213119628L;

	public IntegerTextField() {
		setValue("");
	}

	public IntegerTextField(String caption) {
		this();
		setCaption(caption);
	}

	public IntegerTextField(@SuppressWarnings("rawtypes") Property dataSource) {
		setPropertyDataSource(dataSource);
	}

	public IntegerTextField(String caption, @SuppressWarnings("rawtypes") Property dataSource) {
		this(dataSource);
		setCaption(caption);
	}

	public IntegerTextField(String caption, String value) {
		setValue(value);
		setCaption(caption);
	}

	@Override
	public IntegerTextFieldState getState() {
		return (IntegerTextFieldState) super.getState();
	}

	@Override
	public String getValue() {
		return getState().text;
	}

	@Override
	public void setValue(String value) {
		getState().text = value;
	}
}
