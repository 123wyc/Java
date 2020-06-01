package com.example.wyc.DesignPatterns.link.userVa;


import com.example.wyc.DesignPatterns.link.Handler;
import com.example.wyc.DesignPatterns.link.Request;

public class AgeHandler extends Handler {

	
	
	public AgeHandler() {
		super(2);
	}

	@Override
	public void echo(Request request) {
		System.out.println("age handler");		
	}

	
}
