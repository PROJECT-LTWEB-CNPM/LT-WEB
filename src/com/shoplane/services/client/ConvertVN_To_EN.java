package com.shoplane.services.client;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class ConvertVN_To_EN {
	public static String removeAccent(String string) {

		String temp = Normalizer.normalize(string, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("");
	}
}
