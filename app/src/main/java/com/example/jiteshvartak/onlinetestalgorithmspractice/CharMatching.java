package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class CharMatching {

	static int maxScoreOfVincent(int n, String s, String t) {

		int sum = 0;

		for (int i = 0; i < n; i++) {

			char ch1 = s.charAt(i);
			char ch2 = s.charAt(i);
			if(ch1 != '.' && ch1 != ch2){
				sum++;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Return the maximum score of Vincent.
		int n = in.nextInt();
		String s = in.next();
		String t = in.next();
		int result = maxScoreOfVincent(n, s, t);
		System.out.println(result);
	}

	static void print(String str) {
		System.out.print(str);
	}

	static void println(String str) {
		System.out.println(str);
	}

}
