package com.nutshell.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.ui.*;
import com.nutshell.shared.*;

import gwt.material.design.client.ui.*;

public class summary extends Composite {

	private static summaryUiBinder uiBinder = GWT.create(summaryUiBinder.class);

	interface summaryUiBinder extends UiBinder<Widget, summary> {
	}

	public summary() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public summary(data d) {
		initWidget(uiBinder.createAndBindUi(this));
		t1.setText(d.getImage());
		t2.setText(d.getHeadline());
		t3.setText(d.getTag());
		t4.setText(d.getSummary());
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
	@UiField
	MaterialButton b2;
	
	@UiHandler("b1")
	void  onClick(ClickEvent e) 
	{
		MaterialToast.fireToast("Edit the News");
	}
	
	@UiHandler("b2")
	void  onClick1(ClickEvent e) 
	{
		MaterialToast.fireToast("News Publish Successfuly");
		RootPanel.get("tb2").clear();
		
		data d1=new data();
		d1.setImage(t1.getText());
		d1.setHeadline(t2.getText());
		d1.setTag(t3.getText());
		d1.setSummary(t4.getText());
		
		publish p=new publish(d1);
		RootPanel.get("tb2").add(p);
	}

}
