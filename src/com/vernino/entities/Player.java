package com.vernino.entities;

import java.util.ArrayList;

import com.vernino.misc.Location;
import com.vernino.misc.Physical;

public class Player extends Physical{
	ArrayList<Location> visited = new ArrayList<Location>();

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
	
	public boolean move(int dir){
		loc.move(dir);
		return true;
	}

}
