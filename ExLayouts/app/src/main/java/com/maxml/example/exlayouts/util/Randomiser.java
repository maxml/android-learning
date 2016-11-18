package com.maxml.example.exlayouts.util;

import java.util.Random;

public class Randomiser {

	public static String getRandomText(){
		return getRandomText(10);
	}
	
	public static String getRandomText(int length){
		String res = "";
		
		for (int i = 0; i < length; i++) {
			res += Character.toChars(Math.abs(new Random().nextInt(126)))[0];
		}
		
		return res;
	}
}
