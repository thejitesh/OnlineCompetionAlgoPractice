package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Sorting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<BigInteger> intArryList = new ArrayList<>();
		int n = in.nextInt();
		String[] unsorted = new String[n];
		for (int i = 0; i < n; i++) {
			String intValue = in.next();
			BigInteger bigInt = new BigInteger(intValue);
			if (i == 0) {
				intArryList.add(bigInt);
			} else {
				boolean isValueAdded = false;
				for (int j = 0; j < intArryList.size(); j++) {
					if (intArryList.get(j).compareTo(bigInt) < 1) {
						intArryList.add(j, bigInt);
						isValueAdded = true;
						break;
					}
				}

				if (!isValueAdded) {
					intArryList.add(bigInt);
				}
			}

		}

		for (int i = intArryList.size() - 1; i >= 0; i--) {
			System.out.print(intArryList.get(i) + " ");
		}

	}

}
