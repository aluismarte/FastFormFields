package com.avathartech.fastformfields;

import javax.servlet.annotation.WebServlet;

import com.avathartech.fastformfields.widgets.DecimalTextField;
import com.avathartech.fastformfields.widgets.IntegerTextField;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
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
		DecimalTextField dtf = new DecimalTextField("Con punto");
		IntegerTextField itf = new IntegerTextField("Sin punto");

		VerticalLayout vl = new VerticalLayout();
		vl.addComponent(itf);
		vl.addComponent(dtf);

		dtf.setRequired(true);
		itf.setRequired(true);

		itf.addTextChangeListener(new TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {
				System.out.println("Hola");
			}
		});

		itf.setValue("sdsd1ad2as3.4sda");
		dtf.setValue("df21.2asd.asa1.12as");
		dtf.setReadOnly(true);

		itf.setValue("2265");

		System.out.println(itf.getValue());

		setContent(vl);
	}

}