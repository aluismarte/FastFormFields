package com.avathartech.fastformfields.widgets;

import com.avathartech.fastformfields.widgets.client.decimaltextfield.DecimalTextFieldState;
import com.vaadin.data.Property;
import com.vaadin.ui.TextField;

public class DecimalTextField extends TextField {

	private static final long serialVersionUID = 6515008945711321429L;

	public DecimalTextField() {
		setValue("");
	}
	
	public DecimalTextField(String caption) {
        this();
        setCaption(caption);
    }
    
    public DecimalTextField(@SuppressWarnings("rawtypes") Property dataSource) {
        setPropertyDataSource(dataSource);
    }

    public DecimalTextField(String caption, @SuppressWarnings("rawtypes") Property dataSource) {
        this(dataSource);
        setCaption(caption);
    }

    public DecimalTextField(String caption, String value) {
        setValue(value);
        setCaption(caption);
    }

	@Override
	public DecimalTextFieldState getState() {
		return (DecimalTextFieldState) super.getState();
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
