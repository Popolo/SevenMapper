package com.vernino.building;

import java.util.ArrayList;

import com.vernino.entities.Entity;
import com.vernino.misc.Location;
import com.vernino.misc.Physical;

public class Room extends Physical {
	boolean[] doors;
	ArrayList <Entity> entities = new ArrayList<Entity>();
	
	public final static boolean[] OPEN = {true,true,true,true};

	public Room() {
		super(null);
	}
	
	public Room(Location l){
		super(l);
		this.doors = OPEN;
	}
	
	public Room(boolean[] doors, Location l){
		super(l);
		this.doors = doors;
	}
	
	public boolean[] getDoors(){
		return doors;
	}

	public boolean isReal() {
		return (this.getLocation() != null);
	}
	
	
	
	//STRING METHODS ONLY BELOW
	
	public String toString(){
		return doorsHere() + thingsHere();
	}
	
	private String thingsHere(){
		String s;
		
		if(entities.size() > 0){
			s = "\nStuff Here:\n";
			for(int i = 0; i<entities.size();i++){
				s += "  *" + entities.get(i) + "\n";
			}
		}else{
			s = "\nYou don't see anything else.";
		}
		return s;
	}
	
	private String doorsHere(){
		String s = "Exits are";
		if(doors[0]){
			s += " north";
		}
		if(doors[1]){
			s += " east";
		}
		if(doors[2]){
			s += " south";
		}
		if(doors[3]){
			s += " west";
		}
		
		return s + ".";
	}
}
