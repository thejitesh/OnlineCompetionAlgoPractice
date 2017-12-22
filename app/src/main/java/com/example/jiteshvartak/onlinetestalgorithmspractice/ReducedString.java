package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ReducedString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.next();

		for (int i = 0; i + 1 < string.length();) {

			char currentChar = string.charAt(i);
			char nextChar = string.charAt(i + 1);
			if (currentChar == nextChar) {
				string = string.substring(0, i) + string.substring(i + 2);
				if (i > 0) {
					i--;
				}

			} else {
				i++;
			}

		}

		if (string.isEmpty()) {
			System.out.println("Empty String ");
		} else {
			System.out.println(string);
		}
	}

}
