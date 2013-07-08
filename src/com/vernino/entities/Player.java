package com.vernino.entities;

import com.vernino.building.*;
import com.vernino.misc.Location;
import com.vernino.misc.Physical;

public class Player extends Physical{
	Room current;

	public Player(Location l) {
		super(l);
	}

	@Override
	public boolean isReal() {
		if (this.getLocation() != null){
			return true;
		}
		return false;
	}
	
	public boolean move(int dir, Floor floor){
		Room temp = current;
		if(current.getDoors()[dir]){
			loc.move(dir);
			temp = floor.findRoomAt(loc);
			setCurrentRoom(floor.findRoomAt(loc));
			return true;
		}
		
		return false;
	}
	
	public void setCurrentRoom(Room R){
		current = R;
	}

}
