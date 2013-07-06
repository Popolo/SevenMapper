package com.vernino.building;

import java.util.ArrayList;

import com.vernino.entities.Entity;
import com.vernino.misc.Location;
import com.vernino.misc.Physical;

public class Room extends Physical {
	private RoomType roomType;
	private int rotation;
	ArrayList <Integer> doors;
	ArrayList <Entity> entities;

	public Room() {
		super(null);
		roomType = null;
		rotation = 0;
	}
	
	public Room(RoomType type, int r){
		super(null);
		roomType = type;
		rotation = r;
		doors = this.setDoors();
	}
	
	public Room(RoomType type, int r, Location l){
		this(type, r);
		loc = l;
	}
	
	//getters
	public RoomType getType(){
		return roomType;
	}
	
	public ArrayList<Integer> getDoors(){
		return doors;
	}
	
	public String toString(){
		return roomType.toString();
	}
	
	private ArrayList<Integer> setDoors(){
		ArrayList<Integer> doors = new ArrayList<Integer>();
		switch(roomType){
		case CROSS:
			doors.add(0);
			doors.add(1);
			doors.add(2);
			doors.add(3);
			break;
		case DEAD_END:
			doors.add(0);
			break;
		case ELBOW:
			doors.add(0);
			doors.add(1);
			break;
		case STRAIGHT:
			doors.add(0);
			doors.add(2);
			break;
		case TEE:
			doors.add(0);
			doors.add(1);
			doors.add(3);
			break;
		default:
			return null;
		}
		
		for(int i = 0; i < doors.size(); i++){
			doors.set(i, (doors.get(i) + rotation) % 4);
		}
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
