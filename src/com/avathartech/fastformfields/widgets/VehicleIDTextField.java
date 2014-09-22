package com.avathartech.fastformfields.widgets;

import com.avathartech.fastformfields.widgets.client.vehicleidtextfield.VehicleIDTextFieldState;
import com.vaadin.data.Property;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.ui.TextField;

public class VehicleIDTextField extends TextField {

	private static final long serialVersionUID = 602414522923695628L;

	// Docu http://en.wikipedia.org/wiki/Vehicle_identification_number

	public VehicleIDTextField() {
		setValue("");
	}

	public VehicleIDTextField(String caption) {
		this();
		setCaption(caption);
	}

	public VehicleIDTextField(@SuppressWarnings("rawtypes") Property dataSource) {
		setPropertyDataSource(dataSource);
	}

	public VehicleIDTextField(String caption, @SuppressWarnings("rawtypes") Property dataSource) {
		this(dataSource);
		setCaption(caption);
	}

	public VehicleIDTextField(String caption, String value) {
		setValue(value);
		setCaption(caption);
	}

	@Override
	public VehicleIDTextFieldState getState() {
		return (VehicleIDTextFieldState) super.getState();
	}

	@Override
	public String getValue() {
		return super.getValue();
	}

	@Override
	public void setValue(String value) {
		super.setValue(value);
		getState().text = value;
	}

	private boolean validVIN(String vin) {
		// Only work with USA.
		// European and ISO 3779
		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 2, 3, 4, 5, 0, 7, 0, 9, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] weights = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };
		String s = vin;
		s = s.replaceAll("-", "");
		s = s.toUpperCase();
		if (s.length() != 17) {
			return false;
		}
		int sum = 0;
		for (int i = 0; i < 17; i++) {
			char c = s.charAt(i);
			int value;
			int weight = weights[i];
			if (c >= 'A' && c <= 'Z') {
				value = values[c - 'A'];
				if (value == 0) {
					return false;
				}
			} else if (c >= '0' && c <= '9') {
				value = c - '0';
			} else {
				return false;
			}
			sum = sum + weight * value;
		}
		// check digit
		sum = sum % 11;
		char check = s.charAt(8);
		if (check != 'X' && (check < '0' || check > '9'))
			return false;
		if (sum == 10 && check == 'X') {
			System.out.println("Valid");
			return true;
		} else if (sum == check - '0') {
			System.out.println("Valid");
			return true;
		}
		System.out.println("Invalid");
		return true;
	}

	@Override
	public boolean isValid() {
		try {
			validate();
		} catch (InvalidValueException e) {
			return false;
		}
		return validVIN(getValue());
	}
}