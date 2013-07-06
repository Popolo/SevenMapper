package com.vernino.control;

import com.vernino.entities.Player;

public class Parser {

	public static void getCommand(String s, Player p, GameSession g){
		s = s.toUpperCase();
		String[] args = s.split(" ");
		switch(args[0]){
		case "GO":
			if (args.length > 1){
				switch(args[1]){
				case "NORTH":
					p.move(0);
					break;
				case "EAST":
					p.move(1);
					break;
				case "SOUTH":
					p.move(2);
					break;
				case "WEST":
					p.move(3);
					break;
				}
				g.print(g.look());
			}else{
				g.alert("You can't go nowhere! You're already there!");
			}
		}
	}
}
