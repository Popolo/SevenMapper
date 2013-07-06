package com.vernino.building;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum RoomType {
	STRAIGHT, ELBOW, TEE, CROSS, DEAD_END; 
	
	
	private static final List<RoomType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static RoomType randomType()  {
	    return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
