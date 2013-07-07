package com.vernino.building;

import java.util.ArrayList;
import java.util.Random;

import com.vernino.misc.Location;
import com.vernino.misc.Physical;

public class Floor {
	
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private static Random rnd = new Random();
	
	public Floor() {
		rooms.add(null);
	}
	
	public Floor(Room r){
		rooms.add(r);
	}
	
	public boolean addRoom(Room r){
		if (rooms.size() > 0){
			for(int i = 0; i < rooms.size(); i++){
				if(r.getLocation().equals(rooms.get(i).getLocation())){
					return false;
				}
			}
		}
		rooms.add(r);
		return true;
	}
	
	protected Room findRoomAt(Location l){
		for(int i = 0; i<rooms.size(); i++){
			if(rooms.get(i).getLocation().equals(l)){
				return rooms.get(i);
			}
		}
		return null;
	}
	
	//Room generation.
	public void addNeighbors(Location l){
		for(int i = 0; i < 4; i++){
			this.addGoodRoom(getLocationRelative(l, i));
		}
	}
	
	//Creates a room at location "l" that has doors that match with neighbors.
	private void addGoodRoom(Location l){
		//Breaks if there is a room at that location already.
		if(findRoomAt(l) != null){
			return;
		}
		
		Room r = new Room(l);
		Room[] neighbors = new Room[4];
		
		//Makes sure doors line up.
		for(int i = 0; i < neighbors.length; i++){
			neighbors[i] = findRoomAt(getLocationRelative(l, i));
			if (neighbors[i] != null){
				r.doors[i] = neighbors[i].doors[(i+2) % 4];
			}else{
				r.doors[i] = rnd.nextBoolean();
			}
		}
		
		this.addRoom(r);
	}
	
	//Convenience method.
	private Location getLocationRelative(Location l, int dir){
		switch (dir){
		case Physical.NORTH:
			return new Location(l.getX(),l.getY()-1);
		case Physical.EAST:
			return new Location(l.getX()+1,l.getY());
		case Physical.SOUTH:
			return new Location(l.getX(),l.getY()+1);
		case Physical.WEST:
			return new Location(l.getX()-1,l.getY());
		}
		return null;
	}
}
