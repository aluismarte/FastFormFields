package com.avathartech.fastformfields.widgets.client.decimaltextfield;

import com.vaadin.shared.ui.textfield.AbstractTextFieldState;

public class DecimalTextFieldState extends AbstractTextFieldState {
	private static final long serialVersionUID = -3770632874605735616L;
	
	public int upDigitLimit = 0; // No limit if equal 0
	public int downDigitLimit = 0; // No limit if equal 0
}