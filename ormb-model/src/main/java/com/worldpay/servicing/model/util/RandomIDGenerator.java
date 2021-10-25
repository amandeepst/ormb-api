package com.worldpay.servicing.model.util;

import java.util.List;
import java.security.SecureRandom;

public class RandomIDGenerator {
	private RandomIDGenerator() {

	}

	public static String getNumber1(List<String> perIdNbr) {

		String number = null;
		if (!perIdNbr.isEmpty()) {
			number = numberGenerator();
			number += perIdNbr.get(0);
			return number;
		} else {
			return numberGenerator();
		}
	}

	public static String getNumber(String perIdNbr) {
		String number = numberGenerator();
		number += perIdNbr;
		return number;
	}

	public static String numberGenerator() {

		SecureRandom rand = new SecureRandom();
		int randNum = rand.nextInt(100000000);
		return Integer.toString(randNum);

	}
}
