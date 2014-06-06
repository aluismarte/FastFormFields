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
		return super.getValue();
	}

	@Override
	public void setValue(String value) {
		value = onlyDigitsAndOneDot(value);
		super.setValue(value);
		getState().text = value;
	}

	private String onlyDigitsAndOneDot(String value) {
		boolean hasDot = false;
		String digits = "";
		for (int i = 0; i < value.length(); i++) {
			char chrs = value.charAt(i);
			if (chrs == '.' && hasDot) {
				continue;
			} else if (chrs == '.' && !hasDot) {
				digits = digits + chrs;
				hasDot = true;
			} else if ('.' != chrs && !Character.isDigit(chrs)) {
				continue;
			} else {
				digits = digits + chrs;
			}
		}
		return digits;
	}

	/**
	 * Set limit of digits on Decimal Precision.
	 * 
	 * Set 0 to unlimit
	 */
	public void setDecimalPresicion(int digits) {
		if (digits < 0) {
			getState().downDigitLimit = -1 * digits;
		} else {
			getState().downDigitLimit = digits;
		}
	}

	/**
	 * Set limit of digits on Integer Precision.
	 * 
	 * Set 0 to unlimit
	 */
	public void setIntegerPresicion(int digits) {
		if (digits < 0) {
			getState().upDigitLimit = -1 * digits;
		} else {
			getState().upDigitLimit = digits;
		}
	}

	public int getDecimalPresicion() {
		return getState().downDigitLimit;
	}

	public int getIntegerPresicion() {
		return getState().upDigitLimit;
	}
}
