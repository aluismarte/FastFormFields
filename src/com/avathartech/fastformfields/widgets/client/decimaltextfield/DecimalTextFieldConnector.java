package com.avathartech.fastformfields.widgets.client.decimaltextfield;

import com.avathartech.fastformfields.widgets.DecimalTextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;

@Connect(DecimalTextField.class)
public class DecimalTextFieldConnector extends TextFieldConnector {

	private static final long serialVersionUID = -491559284787322054L;

	// States
	private boolean hasDot = false;
	private boolean hasNum = false;

	// Tools
	private KeyPressHandler keyChecker;
	private int digitUpSize = 0;
	private int digitDownSize = 0;

	public DecimalTextFieldConnector() {
		keyChecker = new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				cancelInvalidKeyPressed(event);
				formatearValor();
			}
		};
		getWidget().addKeyPressHandler(keyChecker);	
	}
	
	private void formatearValor(){
		String valor = getWidget().getValue();
		valor += getState().text;	
		getWidget().setValue(valor);		
	}

	private void cancelInvalidKeyPressed(KeyPressEvent event) {
		if (getWidget().getText().contains(getState().decimalSeparator)) {
			hasDot = true;
		} else {
			hasDot = false;
		}

		// Si el caracter es un punto y ya tiene un punto, lo cancelamos...
		if (getState().decimalSeparator.charAt(0) == event.getCharCode()
				&& hasDot) {
			getWidget().cancelKey();
		} else if (getState().decimalSeparator.charAt(0) != event.getCharCode()
				&& getState().groupingSeparator.charAt(0) != event
						.getCharCode()
				&& !Character.isDigit(event.getCharCode())) {
			// Si el caracter es diferente de un punto o comma y el caracter no
			// es un numero, lo cancelamos
			getWidget().cancelKey();
		} else if (getState().decimalSeparator.charAt(0) == event.getCharCode()
				&& hasDot && !hasNum) {
			// Si el caracter es un punto, pero no ha insertado un numero, lo
			// cancelamos
			getWidget().cancelKey();
		}

		digitUpSize = 0;
		digitDownSize = 0;
		verifyValues();

		if (hasDot) {
			checkDownDigitLimit(event);
		} else {
			checkUpDigitLimit(event);
		}
		
		String format = "";
		for(int i = 0; i < getState().upDigitLimit; i++){
			for(int j = 0; j < getState().groupingSize; j++){
				format += "#";
			}
			format += getState().groupingSeparator;
		}
		format += getState().decimalSeparator;
		for(int k=0; k < getState().downDigitLimit; k++){
			format += "#";
		}		
		System.out.println("Formato: " + format);
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
		
		String format = "";
		for(int i = 0; i < getState().upDigitLimit; i++){
			for(int j = 0; j < getState().groupingSize; j++){
				format += "#";
			}
			format += getState().groupingSeparator;
		}
		format += getState().decimalSeparator;
		for(int k=0; k < getState().downDigitLimit; k++){
			format += "#";
		}		
		System.out.println("Formato: " + format);
		
		final String text = getState().text;		
		getWidget().setText(text);
	}

	/*
	 * private void checkValue(KeyPressEvent event) { if
	 * (getWidget().getText().contains(".")) { hasDot = true; } else { hasDot =
	 * false; } if ('.' == event.getCharCode() && hasDot) {
	 * getWidget().cancelKey(); } else if ('.' != event.getCharCode() &&
	 * !Character.isDigit(event.getCharCode())) { getWidget().cancelKey(); }
	 * else if ('.' == event.getCharCode() && hasDot && !hasNum) {
	 * getWidget().cancelKey(); } digitUpSize = 0; digitDownSize = 0;
	 * verifyValues(); if (hasDot) { checkDownDigitLimit(event); } else {
	 * checkUpDigitLimit(event); } }
	 */

	private void checkUpDigitLimit(KeyPressEvent event) {
		if (getState().upDigitLimit > 0) {
			if (getState().decimalSeparator.charAt(0) != event.getCharCode()
					&& getState().groupingSeparator.charAt(0) != event
							.getCharCode()) {
				if (digitUpSize >= getState().upDigitLimit) {
					getWidget().cancelKey();
				} else {
					digitUpSize += 1;
				}
			}
		}
	}

	private void checkDownDigitLimit(KeyPressEvent event) {
		if (getState().downDigitLimit > 0) {
			if (digitDownSize >= getState().downDigitLimit) {
				getWidget().cancelKey();
			} else {
				digitDownSize += 1;
			}
		}
	}

	private void verifyValues() {
		String t = getWidget().getValue();
		hasDot = false;
		if (t.length() > 0) {
			for (int i = 0; i < t.length(); i++) {
				char chrs = t.charAt(i);

				// Si el caracter es un separador de decimales, continuamos, no
				// la contamos en la cantidad de digitos despues del punto.
				if (chrs == getState().decimalSeparator.charAt(0)) {
					hasDot = true;
					continue;
				}

				// Si el caracter es una comma, continuamos, no la contamos en
				// la cantidad de digitos
				if (chrs == getState().groupingSeparator.charAt(0)) {
					continue;
				}

				// Dependiendo de si ya paso el punto, sumamos el total de
				// digitos despues del punto y antes del punto.
				if (hasDot) {
					digitDownSize += 1;
				} else {
					digitUpSize += 1;
				}
			}
		}
	}
}