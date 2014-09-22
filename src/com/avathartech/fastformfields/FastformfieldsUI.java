package com.avathartech.fastformfields;

import javax.servlet.annotation.WebServlet;

import com.avathartech.fastformfields.widgets.DecimalTextField;
import com.avathartech.fastformfields.widgets.IntegerTextField;
import com.avathartech.fastformfields.widgets.UpperTextField;
import com.avathartech.fastformfields.widgets.VehicleIDTextField;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("fastformfields")
public class FastformfieldsUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = FastformfieldsUI.class, widgetset = "com.avathartech.fastformfields.widgets.FastformfieldsWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final DecimalTextField dtf = new DecimalTextField("DecimalTextField:");
		dtf.setRequired(true);
		dtf.setValue("");
		dtf.setImmediate(true);
		dtf.setIntegerPresicion(7);
		dtf.setDecimalPresicion(2);
		dtf.setGroupingSize(3);
		dtf.setGroupingSeparator(",");
		dtf.setDecimalSeparator(".");
		dtf.addValueChangeListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(Property.ValueChangeEvent event) {
				System.out.println("=======================================================");
				System.out.println("Digitos antes del punto: " + dtf.getState().upDigitLimit);
				System.out.println("Digitos despues del punto: " + dtf.getState().downDigitLimit);
				System.out.println("Grouping size: " + dtf.getState().groupingSize);
				System.out.println("Thousand separator: " + dtf.getState().groupingSeparator);
				System.out.println("Decimal separator: " + dtf.getState().decimalSeparator);
				System.out.println("=======================================================");

				String format1 = "";
				int cont = 0;
				for (int i = dtf.getState().upDigitLimit; i > 0; i--) {
					format1 += "#";
					cont++;
					if (cont == dtf.getState().groupingSize) {
						format1 += dtf.getState().groupingSeparator;
						cont = 0;
					}
				}

				String newString = "";
				for (int i = format1.length() - 1; i >= 0; i--) {
					newString += format1.charAt(i);
				}

				String format2 = "";
				for (int k = 0; k < dtf.getState().downDigitLimit; k++) {
					format2 += "#";
				}

				String formato = newString + dtf.getState().decimalSeparator + format2;
				// dtf.setValue(String.format(formato, dtf.getValue()));
				System.out.println(formato);
			}
		});

		IntegerTextField itf = new IntegerTextField("IntegerTextfield:");
		itf.setRequired(true);
		itf.setValue("2265");
		itf.setIntegerPresicion(6);
		itf.addTextChangeListener(new TextChangeListener() {
			@Override
			public void textChange(TextChangeEvent event) {
				System.out.println("Hola");
			}
		});

		UpperTextField utf = new UpperTextField("UpperTextField:");
		utf.setImmediate(true);
		utf.setValue("asd asdsad");

		final VehicleIDTextField vidtf = new VehicleIDTextField("Chasis");

		Button button = new Button("Check Vehicle ID");
		button.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				System.out.println(vidtf.getValue());
				if (vidtf.isValid()) {
					System.out.println("Good");
				} else {
					System.out.println("Bad");
				}
			}
		});

		VerticalLayout vl = new VerticalLayout();
		vl.addComponent(itf);
		vl.addComponent(dtf);
		vl.addComponent(utf);
		vl.addComponent(vidtf);
		vl.addComponent(button);

		setContent(vl);
	}
}