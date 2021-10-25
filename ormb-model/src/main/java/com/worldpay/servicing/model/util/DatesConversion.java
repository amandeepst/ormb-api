package com.worldpay.servicing.model.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatesConversion {
	private DatesConversion() {

	}

	public static String convertLocalDateToString(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(formatter);

	}

}
