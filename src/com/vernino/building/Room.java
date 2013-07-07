package com.vernino.building;

import java.util.ArrayList;

import com.vernino.entities.Entity;
import com.vernino.misc.Location;
import com.vernino.misc.Physical;

public class Room extends Physical {
	boolean[] doors;
	ArrayList <Entity> entities;
	
	public final static boolean[] OPEN = {true,true,true,true};

	public Room() {
		super(null);
	}
	
	public Room(Location l){
		super(null);
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
	
	public String thingsHere(){
		String s = "Stuff Here:\n";
		for(int i = 0; i<entities.size();i++){
			s += "  *" + entities.get(i) + "\n";
		}
		return s;
	}

}
