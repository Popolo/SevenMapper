package com.vernino.building;

import java.util.ArrayList;

import com.vernino.misc.Location;

public class Floor {
	
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
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
	
	//ignore this, it's not what I want.
	private void createCompatibleRooms(Room r){
		ArrayList<Integer> doors = r.getDoors();
		int x = r.getLocation().getX();
		int y = r.getLocation().getY();
		int rot = 0;
		for(int i = 0; i < doors.size(); i++){
			Location l = null;
			switch (doors.get(i)){
			case 3:
				rot = 1;
				l = new Location(x-1,y);
				break;
			case 0:
				rot = 2;
				l = new Location(x,y+1);
				break;
			case 1:
				rot = 3;
				l = new Location(x+1,y);
				break;
			case 2:
				l = new Location(x,y+1);
				break;
			}
			addRoom(new Room(RoomType.randomType(),rot,l));
		}
	}
}
