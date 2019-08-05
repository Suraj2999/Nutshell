package com.nutshell.client;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.*;


public class login extends Composite {

	GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	
	private static loginUiBinder uiBinder = GWT.create(loginUiBinder.class);

	interface loginUiBinder extends UiBinder<Widget, login> {
	}

	public login() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiField
	MaterialTextBox t1;
	@UiField
	MaterialTextBox t2;
	@UiField
	MaterialButton b1;
	
	@UiHandler("b1")
	void onClick(ClickEvent e)
	{
		String s1=t1.getText();
		String s2=t2.getText();
		
		a1.login(s1, s2, new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("Yes"))
					MaterialToast.fireToast("Login Successfuly");
				else
				{
					MaterialToast.fireToast("Invalid id or password");
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
