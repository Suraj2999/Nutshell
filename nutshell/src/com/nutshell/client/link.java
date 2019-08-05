package com.nutshell.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.nutshell.shared.*;
import gwt.material.design.client.ui.*;

public class link extends Composite {
	
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	private static linkUiBinder uiBinder = GWT.create(linkUiBinder.class);

	interface linkUiBinder extends UiBinder<Widget, link> 
	{
	}

	public link() 
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
	public link(String firstName)
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiField
	MaterialTextArea t1;
	@UiField
	MaterialTextArea t2;
	@UiField
	MaterialTextArea t3;
	@UiField
	MaterialTextArea t4;
	@UiField
	MaterialButton b1;

	@UiHandler("b1")
	void onClick(ClickEvent e) {
		RootPanel.get("tb2").clear();
		
		String longnews=t4.getText();//pass this long news to summary algorithm
		String shortnews="Short news is created";//get short news from summary algorithm
		
		data d=new data();
		d.setImage(t1.getText());
		d.setHeadline(t2.getText());
		d.setTag(t3.getText());
		d.setSummary(shortnews);
		
		summary s1 = new summary(d);
		RootPanel.get("tb2").add(s1);

	}
	
}
