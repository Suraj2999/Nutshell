package com.nutshell.shared;

import java.io.Serializable;

public class heading implements Serializable {
	int n;
	String a[]=new String[n];
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String[] getA() {
		return a;
	}
	public void setA(String[] a) {
		this.a = a;
	}
	
}