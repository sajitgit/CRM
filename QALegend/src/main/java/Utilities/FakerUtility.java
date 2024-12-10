package Utilities;

import java.util.Random;
import java.util.UUID;

public class FakerUtility {

	public static int randomNumberGenerator() {
		
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(100000);
		return randomNumber;
	}
	
	
	public static String uniqueStringGenerator() {
	return String.format("%s", UUID.randomUUID().toString().substring(0,5));
	}
	
	
}
