package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class SockStock {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c[] = new int[n];
		HashMap<Integer, Integer> hmColorSockCount = new HashMap<>();
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();

			Integer sockCounter = hmColorSockCount.get(c[c_i]);
			if (sockCounter == null) {
				hmColorSockCount.put(c[c_i], 1);
			} else {
				hmColorSockCount.put(c[c_i], sockCounter.intValue() + 1);
			}
		}
		in.close();

		int maxPair = 0;
		for (Integer intValue : hmColorSockCount.values()) {
			maxPair += intValue.intValue() / 2;
		}

		System.out.println(maxPair);

	}

}
