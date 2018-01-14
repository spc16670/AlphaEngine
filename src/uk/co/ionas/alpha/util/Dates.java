package uk.co.ionas.alpha.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Dates {

	public static LocalDateTime toLocalDateTime(String str, String format) {	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return LocalDateTime.parse(str, formatter);
	}
}
