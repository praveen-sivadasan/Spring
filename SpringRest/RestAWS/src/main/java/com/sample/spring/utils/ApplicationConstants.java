package com.sample.spring.utils;

import java.util.ArrayList;
import java.util.List;

public class ApplicationConstants {
	private static List<String> output;

	public static List<String> getOutput() {
		if (output == null) {
			output = new ArrayList<>();
			return output;
		} else {
			return output;
		}
	}
	
	public static void resetOutput() {
		output = new ArrayList<>();
	}
}
