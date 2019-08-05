package com.nutshell.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.nutshell.shared.*;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialToast;

public class publish extends Composite {
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	private static publishUiBinder uiBinder = GWT.create(publishUiBinder.class);

	interface publishUiBinder extends UiBinder<Widget, publish> {
	}

	public publish() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public publish(data d) {
		initWidget(uiBinder.createAndBindUi(this));
		t1.setText(d.getImage());
		t2.setText(d.getHeadline());
		t3.setText(d.getTag());
		t4.setText(d.getSummary());
		
		a1.finalsummary(d, new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if (result.equals("Yes"))
					MaterialToast.fireToast("Data Added Successfully");
				else
					MaterialToast.fireToast("Error Something went Wrong");

			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MaterialToast.fireToast(caught.getMessage());
			}
		});
	}

	@UiField
	MaterialTextArea t1;
	@UiField
	MaterialTextArea t2;
	@UiField
	MaterialTextArea t3;
	@UiField
	MaterialTextArea t4;
}
