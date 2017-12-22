package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class SOS {
	public static void main(String[] args) {

		initInput();
		String str = nextLine();
		int stringLength = str.length();
		int count = 0;
		for (int i = 0; i < stringLength; i++) {

			if (str.charAt(i) != "SOS".charAt(i % 3)) {
				count++;
			}

		}

		print(count + "");
	}

	static Scanner in;

	static void initInput() {
		in = new Scanner(System.in);
	}

	static int nextInt() {
		return in.nextInt();
	}

	static String nextLine() {
		return in.nextLine();
	}

	static void print(String str) {
		System.out.println(str);
	}

}