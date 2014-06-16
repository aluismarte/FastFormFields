package com.avathartech.fastformfields.tools;

import java.util.HashMap;
import java.util.Map;

public class VINConstant {
	public static Map<String, Integer> YEAR_INDEX = new HashMap<String, Integer>();
	public static String YEAR_CHARS[] = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "V", "W", "X", "Y", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

	public static final Map<String, Integer> ALPHABET_INDEX = new HashMap<String, Integer>();
	public static final String ALPHABET_CHARS[] = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "0" };

	public static final Map<String, Integer> WEIGHTS = new HashMap<String, Integer>();
	public static final int ALPHABET_WEIGHTS[] = {
			// A,B,C,D,E,F,G,H,J,K,L,M,N,P,R
			1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 7, 9,
			// S,T,U,V,W,X,Y,Z,1,2,3,4,5,6,7
			2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7,
			// 8,9,0
			8, 9, 0 };

	public static int WEIGHT_FACTOR[] = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };

	static {
		int len = VINConstant.ALPHABET_CHARS.length;
		for (int i = 0; i < len; i++) {
			ALPHABET_INDEX.put(VINConstant.ALPHABET_CHARS[i], i);
		}

		for (int i = 0; i < len; i++) {
			WEIGHTS.put(VINConstant.ALPHABET_CHARS[i], ALPHABET_WEIGHTS[i]);
		}

		len = VINConstant.YEAR_CHARS.length;
		for (int i = 0; i < len; i++) {
			YEAR_INDEX.put(VINConstant.YEAR_CHARS[i], i);
		}
	}
}
