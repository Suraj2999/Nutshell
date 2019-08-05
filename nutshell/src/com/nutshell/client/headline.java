package com.nutshell.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.nutshell.shared.*;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialListBox;

public class headline extends Composite {
	
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	private static headlineUiBinder uiBinder = GWT.create(headlineUiBinder.class);

	interface headlineUiBinder extends UiBinder<Widget, headline> {
	}

	public headline() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField
	MaterialListBox category;
	@UiField
	MaterialCollection t1;
	@UiField
	MaterialButton b2;
	
	@UiHandler("b2")
	void  onClick1(ClickEvent e) 
	{
		String f=category.getSelectedItemText();
		a1.fheadline(f, new AsyncCallback<heading>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(heading result) {
				int n;
				n=result.getN();
				String a[]=new String[n];
				a=result.getA();
				for(int i=0;i<n;i++)
				{
					MaterialCollectionItem mci=new MaterialCollectionItem();
					MaterialLink ml=new MaterialLink();
					ml.setText(a[i]);
					ml.setTextColor(Color.BLUE);
					mci.add(ml);
					t1.add(mci);
					mci.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							String x=ml.getText();
							RootPanel.get("tb2").clear();
							link l2=new link();
							RootPanel.get("tb2").add(l2);
							a1.addheadline(x, new AsyncCallback<data>() {
								
								@Override
								public void onSuccess(data result) {
									// TODO Auto-generated method stub
									l2.t1.setText(result.getImage());
									l2.t2.setText(result.getHeadline());
									l2.t3.setText(result.getTag());
									l2.t4.setText(result.getSummary());
								}
								
								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}
							});
							
							
						}
					});
				}
				
				
			}
		});
	
	}
	
	

			
}
