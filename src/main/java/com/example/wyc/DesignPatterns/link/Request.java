package com.example.wyc.DesignPatterns.link;

public class Request {

	
	private int requestLevel;

	public int getRequestLevel() {
		return requestLevel;
	}

	public void setRequestLevel(int requestLevel) {
		this.requestLevel = requestLevel;
	}
	
	public Request(int requestLevel) {
		
		this.requestLevel = requestLevel;
	}
	
}
