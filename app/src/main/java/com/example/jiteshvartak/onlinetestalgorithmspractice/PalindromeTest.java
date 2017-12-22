package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PalindromeTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int arr[][] = new int[n][m];
		


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(in.next());
			}
		}

		int row = n;
		int col = m;
		boolean isRowConsidered = false;
		while (true) {

			int newArr[] = new int[row * col];
			int count = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					newArr[count++] = arr[i][j];
				}
			}

			if (canBeTurnedIntoAPalindrome(newArr)) {
				print(row + "  " + col);
				break;
			}

			if (!isRowConsidered) {
				row--;
				if (row <= 1) {
					isRowConsidered = true;
					row = n;
					col--;

				}
			} else {
				col--;
				if (col <= 1) {
					col = m;
					row = n - 1;
					isRowConsidered = false;
					// print("breaking lopp no palindrome found");
					// break;
				}
			}

		}

		in.close();
	}

	static void print(String str) {
		System.out.println(str);
	}

	static boolean canBeTurnedIntoAPalindrome(int[] drome) {
		// If we've found a letter that has no match, the center letter.
		boolean centerUsed = false;
		int center = 0;

		int c;
		int count = 0;

		// TODO: Remove whitespace from the string.

		// Check each letter to see if there's an even number of it.
		for (int i = 0; i < drome.length; i++) {
			c = drome[i];
			count = 0;

			for (int j = 0; j < drome.length; j++)
				if (drome[j] == c)
					count++;

			// If there was an odd number of those entries
			// and the center is already used, then a palindrome
			// is impossible, so return false.
			if (count % 2 == 1) {
				if (centerUsed == true && center != c)
					return false;
				else {
					centerUsed = true;
					center = c; // This is so when we encounter it again it
								// doesn't count it as another separate center.
				}
			}
		}
		// If we made it all the way through that loop without returning false,
		// then
		return true;
	}

}