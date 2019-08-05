package com.nutshell.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.ui.*;

import gwt.material.design.client.ui.MaterialLink;

public class dashboard extends Composite {

	private static dashboardUiBinder uiBinder = GWT.create(dashboardUiBinder.class);

	interface dashboardUiBinder extends UiBinder<Widget, dashboard> {
	}

	public dashboard() {
		initWidget(uiBinder.createAndBindUi(this));
	} 
	@UiField
	MaterialLink l1;
	@UiField
	MaterialLink l2;
	@UiField
	MaterialLink l3;
	@UiField
	MaterialLink l4;
	@UiField
	MaterialLink c;
	
	
	
	@UiHandler("l2")
	void  onClick(ClickEvent e) 
	{
		RootPanel.get("tb2").clear();
		login l1=new login();
		RootPanel.get("tb2").add(l1);
	}
	@UiHandler("l3")
	void  onClick1(ClickEvent e) 
	{
		RootPanel.get("tb2").clear();
		addnews a1=new addnews();
		RootPanel.get("tb2").add(a1);
	}
	
	@UiHandler("c")
	void  onClick2(ClickEvent e) 
	{
		RootPanel.get("tb2").clear();
		categoryview c1=new categoryview();
		RootPanel.get("tb2").add(c1);
	}
	
	@UiHandler("l1")
	void  onClick3(ClickEvent e) 
	{
		RootPanel.get("tb2").clear();
		registration r=new registration();
		RootPanel.get("tb2").add(r);
	}

	@UiHandler("l4")
	void  onClick4(ClickEvent e) 
	{
		RootPanel.get("tb2").clear();
		headline h1=new headline();
		RootPanel.get("tb2").add(h1);
	}
}
