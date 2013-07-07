package com.vernino.misc;

public class Location {
	private int x;
	private int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void move(int dir){
		switch (dir){
		case 0:
			y += 1;
			break;
		case 1:
			x += 1;
			break;
		case 2:
			y -= 1;
			break;
		case 3:
			x -= 1;
			break;
		}
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}
	
	public boolean equals(Object obj){
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return (((Location) obj).x == this.x && ((Location) obj).y == this.y);
	}
}
