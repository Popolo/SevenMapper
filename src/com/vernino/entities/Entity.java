package com.vernino.entities;

import com.vernino.building.Floor;
import com.vernino.building.Room;

public interface Entity {
	
	//Return true is the action is not aborted.
	public abstract boolean act();
	
	//Return the room containing the entity
	public abstract Room getRoom(Floor container);
	
	//Remove the object without destroying it.
	public abstract void remove();
}
