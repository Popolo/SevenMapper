package com.vernino.misc;

public abstract class Physical {
	
	public final static int NORTH = 0;
	public final static int EAST = 1;
	public final static int SOUTH = 2;
	public final static int WEST = 3;
	
	protected Location loc;
	
	public Physical(Location l){
		this.loc = l;
	}
	
	public Location getLocation(){
		return loc;
	}
	public abstract boolean isReal();
}
