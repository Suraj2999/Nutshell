package com.nutshell.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.nutshell.shared.*;
/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void publish(data d, AsyncCallback<String> callback) throws IllegalArgumentException;
	void finalsummary(data d, AsyncCallback<String> callback) throws IllegalArgumentException;
	void login(String s1,String s2, AsyncCallback<String> callback)throws IllegalArgumentException;
	void sign(details r, AsyncCallback<String> callback)throws IllegalArgumentException;
	void addheadline(String h, AsyncCallback<data> callback) throws IllegalArgumentException;
	void fheadline(String f,AsyncCallback<heading> callback)throws IllegalArgumentException;
}
