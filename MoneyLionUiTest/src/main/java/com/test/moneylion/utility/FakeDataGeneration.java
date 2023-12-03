package com.test.moneylion.utility;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakeDataGeneration {

	static Faker faker = new Faker(new Locale("en-US"));

	public static String generateName() {

		return faker.name().firstName();

	}

	public static String generateLastName() {

		return faker.name().lastName();

	}

	public static String generateEmail() {

		return faker.internet().emailAddress();

	}

	public static String generateAddress() {

		return faker.address().fullAddress();

	}

	public static String generateCity() {

		return faker.address().city();

	}

	public static String generateState() {

		return faker.address().state();

	}

	public static String generateZipCode() {

		return faker.address().zipCode();

	}

	public static String generatePhoneNumber() {

		return faker.phoneNumber().subscriberNumber(10);

	}

	public static String date() {

		return Integer.toString(faker.number().numberBetween(1, 9));

	}

	public static String year() {

		return Integer.toString(faker.number().numberBetween(1991, 2019));

	}

}
