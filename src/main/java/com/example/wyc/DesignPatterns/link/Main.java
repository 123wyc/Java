package com.example.wyc.DesignPatterns.link;


import com.example.wyc.DesignPatterns.link.userVa.AgeHandler;
import com.example.wyc.DesignPatterns.link.userVa.SexHandler;

public class Main {

	
	
	public static void main(String[] args) {
	
		 AgeHandler ageHanlder = new AgeHandler();
		 SexHandler sexHandler = new SexHandler();
		 
		 sexHandler.setNextHandler(ageHanlder);
		 sexHandler.handleMessage(new Request(2));
	}
}


