package com.nutshell.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Nutshell implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		dashboard d=new dashboard();
		RootPanel.get("tb1").add(d);
	
		
		
		/*History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
			
			myspace.getInstance().koifunction();
			
			
		}
		
	});*/
		
	}
	
}
