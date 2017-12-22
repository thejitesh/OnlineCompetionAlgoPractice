package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExExample {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int q = in.nextInt();

		for (int i = 0; i < q; i++) {

			String s = in.next();

			Pattern pattern = Pattern.compile("1[0]+1");
			Matcher matcher = pattern.matcher(s);

			int matchCount = 0;
			boolean found = matcher.find();
			while (found) {
				matchCount += 1;
				found = matcher.find(matcher.start() + 1);
			}

			System.out.println(matchCount); // prints 3
		}
		in.close();

	}

	static void print(String str) {
		System.out.println(str);
	}

}