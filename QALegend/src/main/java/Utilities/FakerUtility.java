package Utilities;

import java.util.Random;
import java.util.UUID;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakerUtility {

	public static int randomNumberGenerator() {
		
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(100000);
		return randomNumber;
	}
	
	
	public static String uniqueStringGenerator() {
	return String.format("%s", UUID.randomUUID().toString().substring(0,5));
	}
	
	
	public static String getFakeFirstname() {
		
		Faker faker = new Faker();
		Address address = faker.address();
		String text = address.firstName();
		return text;
	}
	
}
