package com.nutshell.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class categoryview extends Composite {

	private static categoryviewUiBinder uiBinder = GWT.create(categoryviewUiBinder.class);

	interface categoryviewUiBinder extends UiBinder<Widget, categoryview> {
	}

	public categoryview() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
