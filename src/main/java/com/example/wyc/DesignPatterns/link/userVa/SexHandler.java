package com.example.wyc.DesignPatterns.link.userVa;


import com.example.wyc.DesignPatterns.link.Handler;
import com.example.wyc.DesignPatterns.link.Request;

public class SexHandler extends Handler {

	
	
	public SexHandler() {
		super(1);
	}

	@Override
	public void echo(Request request) {
		System.out.println("sex handler");
	}

	
}
