package com.vernino.entities;

public enum ItemID {
	SPRAY_ON_JEANS ("Spray-On Jeans");
	
	private final String printName;
	
	ItemID(String name){
		printName = name;
	}
	
	public String toString(){
		return printName;
	}
}
