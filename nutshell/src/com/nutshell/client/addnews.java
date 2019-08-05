package com.nutshell.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.nutshell.shared.data;

import gwt.material.design.client.ui.*;

public class addnews extends Composite {
	
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	private static addnewsUiBinder uiBinder = GWT.create(addnewsUiBinder.class);

	interface addnewsUiBinder extends UiBinder<Widget, addnews> {
	}

	public addnews() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiField
	MaterialListBox category;
	@UiField
	MaterialTextBox t1;
	@UiField
	MaterialTextBox t2;
	@UiField
	MaterialTextBox t3;
	@UiField
	MaterialTextArea t4;
	@UiField
	MaterialButton b1;
	@UiField
	MaterialButton b2;
	
	
	@UiHandler("b2")
	void  onClick(ClickEvent e) 
	{
		data d = new data();
		d.setImage(t1.getText());
		d.setHeadline(t2.getText());
		d.setTag(t3.getText());
		d.setSummary(t4.getText());
		d.setCategory(category.getSelectedItemText());
		a1.publish(d, new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("Yes"))
					MaterialToast.fireToast("Data Added Successfully");	
				else
					MaterialToast.fireToast("Error");
					
				}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MaterialToast.fireToast(caught.getMessage());
			}
		});
	}
	
}
