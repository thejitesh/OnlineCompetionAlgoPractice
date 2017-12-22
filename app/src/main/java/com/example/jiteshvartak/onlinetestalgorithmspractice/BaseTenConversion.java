package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Executors;

public class BaseTenConversion {

	static int getMagicNumber(String s, int k, int b, int m) {
		int returnValue = 0;

		for (int i = 0; i + k <= s.length(); i++) {
			int baseValue = 0;
			String str = s.substring(i, i + k);
			for (int j = 0; j < str.length(); j++) {
				int intValue = Integer.parseInt(str.charAt(j) + "");
				int baseValueLocal = intValue * (int) Math.pow(b, (str.length() - 1) - j);
				baseValue += baseValueLocal;
			}

			int modValue = baseValue % m;
			returnValue += modValue;

		}

		return returnValue;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int k = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int result = getMagicNumber(s, k, b, m);
		System.out.println(result);
	}
}
