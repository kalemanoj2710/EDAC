package utils;

import custom_exceptions.SpeedOutOfRangeException;

public class ValidationRules  {
	//speed range
	public static final int MIN_SPEED,MAX_SPEED;
	static 
	{
		MIN_SPEED=40;
		MAX_SPEED=80;
	}
	
	//add a static method for validating speed.
	public static void validateSpeed(int speed) throws SpeedOutOfRangeException
	{
		if(speed < MIN_SPEED)
			throw new SpeedOutOfRangeException("You are driving too slow!!!!");
		if(speed > MAX_SPEED)
			throw new SpeedOutOfRangeException("You are driving too fast FATAL !!!!");
		System.out.println("Speed witnin range...");
	}

}
