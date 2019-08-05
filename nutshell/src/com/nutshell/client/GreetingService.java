package com.nutshell.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.nutshell.shared.*;
/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String login(String s1,String s2) throws IllegalArgumentException;
	String sign(details r) throws IllegalArgumentException;
	String publish(data d) throws IllegalArgumentException;
	String finalsummary(data d) throws IllegalArgumentException;
	data addheadline(String h)throws IllegalArgumentException;
	heading fheadline(String h)throws IllegalArgumentException;
}
