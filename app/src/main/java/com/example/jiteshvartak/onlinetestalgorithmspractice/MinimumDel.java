package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class MinimumDel {

	static int minimumDeletions(int[] a) {

		if (a.length == 1 || a.length == 2) {
			return 0;
		}

		int minDel = 0;

		// -1 : Decrement
		// +1 : Increment
		int previousState = a[0] < a[1] ? 1 : -1;

		for (int i = 1; i < a.length-1; i++) {
			int nextState = a[i] < a[i + 1] ? 1 : -1;
			if (previousState == nextState) {
				minDel++;
			} else {
				previousState = nextState;
			}

		}

		return minDel;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		// Return the minimum number of elements to delete to make the array
		// zigzag
		int result = minimumDeletions(a);
		System.out.println(result);
	}

}
