package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class PanagramTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		s = s.toLowerCase();
		int a[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 97 && c <= (97 + 26)) {
				a[c - 'a']++;
			}
		}

		boolean isPanaGram = true;
		for (int i = 0; i < 26; i++) {
			if (a[i] == 0) {
				isPanaGram = false;
			}
		}
		in.close();

		System.out.println(isPanaGram ? "pangram" : "not pangram");
	}

	static void print(String str) {
		System.out.println(str);
	}

	static class Node {
		int index;
		int value;

	}

}