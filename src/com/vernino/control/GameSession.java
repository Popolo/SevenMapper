package com.vernino.control;
import java.util.ArrayList;

import com.vernino.building.Floor;
import com.vernino.building.Room;
import com.vernino.building.RoomType;
import com.vernino.entities.Entity;
import com.vernino.entities.Player;
import com.vernino.misc.Location;


public class GameSession {
	private Floor building;
	private Player player;
	
	GameSession(){
		player = new Player(new Location(0,0));
		building = new Floor(new Room(RoomType.CROSS, 0, new Location(0,0)));
	}
	
	void command(String s){
		Parser.getCommand(s, player, this);
	}
	
	String look(){
		return player.getLocation().toString();
	}
	
	void alert(String s){
		Main.frame.alert(s);
	}
	
	void print(String s){
		Main.frame.print(s);
	}
}