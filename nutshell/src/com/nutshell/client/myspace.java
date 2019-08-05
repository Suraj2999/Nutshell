package com.nutshell.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

public class myspace {

	static myspace me = null;
	registration r1 = null;

	private myspace() {

	}

	static myspace getInstance() {

		if (me == null)
			me = new myspace();
		return me;
	}

	public void koifunction() {

		if (History.getToken().equals("a1")) {
			RootPanel.get("tb2").clear();
			RootPanel.get("tb2").add(getregistration());

		}

	}

	registration getregistration() {
		if (r1 == null) {

			r1 = new registration();
		}
		return r1;

	}

}
