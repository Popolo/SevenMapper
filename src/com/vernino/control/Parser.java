package com.vernino.control;

import com.vernino.entities.Player;

public class Parser {

	public static void getCommand(String s, Player p, GameSession g){
		s = s.toUpperCase();
		String[] args = s.split(" ");
		boolean goodCommand = false;
		
		switch(args[0]){
		case "GO":
			if (args.length > 1){
				switch(args[1]){
				case "NORTH":
					goodCommand = p.move(0, g.getFloor());
					break;
				case "EAST":
					goodCommand = p.move(1, g.getFloor());
					break;
				case "SOUTH":
					goodCommand = p.move(2, g.getFloor());
					break;
				case "WEST":
					goodCommand = p.move(3, g.getFloor());
					break;
				}
				if(goodCommand){
					g.print(g.look());
				}else{
					g.alert("You can't go that way.");
				}
			}else{
				g.alert("You can't go nowhere! You're already there!");
			}
			break;
		case "LOOK":
			g.print(g.look());
			break;
		}
	}
}
