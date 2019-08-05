package com.nutshell.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.nutshell.shared.*;

import gwt.material.design.client.ui.*;

public class registration extends Composite  {
	
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	private static NavUiBinder uiBinder = GWT.create(NavUiBinder.class);

	interface NavUiBinder extends UiBinder<Widget,registration> {
	}

	public registration() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	MaterialTextBox t1;
	@UiField
	MaterialTextBox t2;
	@UiField
	MaterialTextBox t3;
	@UiField
	MaterialTextBox t4;
	@UiField
	MaterialTextBox t5;
	@UiField
	MaterialTextBox t6;
	@UiField
	MaterialButton b1;
	
	@UiHandler("b1")
	void  onClick4(ClickEvent e) 
	{
		/*History.newItem("a1");
		myspace.getInstance().koifunction();*/
		
		details r=new details();
		
		r.setName(t1.getText());
		r.setEmail_id(t2.getText());
		r.setNews_agency(t3.getText());
	    r.setPhone(Integer.parseInt(t4.getText()));
		r.setPassword(t5.getText());
		
		
		a1.sign(r, new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("Yes"))
					MaterialToast.fireToast("Registered Successfuly");
				else
				{
					MaterialToast.fireToast("Something Went Wrong Please Try Again");
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MaterialToast.fireToast(caught.getMessage());
			}
		});
	}
	
	
	
		
	}


