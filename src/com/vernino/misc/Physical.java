package com.vernino.misc;

public abstract class Physical {
	
	protected final int NORTH = 0;
	protected final int EAST = 1;
	protected final int SOUTH = 2;
	protected final int WEST = 3;
	
	protected Location loc;
	
	public Physical(Location l){
		this.loc = l;
	}
	
	public Location getLocation(){
		return loc;
	}
	public abstract boolean isReal();
}
