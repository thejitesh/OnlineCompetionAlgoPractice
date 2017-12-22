package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SavePrincess {

	static void displayPathtoPrincess(int n, String[] grid) {

		int botRowPos = 0, botColPos = 0;
		int princessRowPos = 0, princessColPos = 0;

		for (int j = 0; j < grid.length; j++) {
			String str = grid[j];
			for (int i = 0; i < str.length(); i++) {

				if ('m' == str.charAt(i)) {
					botRowPos =j;
					botColPos = i ;
				} else if ('p' == str.charAt(i)) {
					princessRowPos = j;
					princessColPos = i;
				}
			}

		}

		int verticalMovement = Math.abs(princessRowPos - botRowPos);
		if (princessRowPos > botColPos) {
			// moving down
			printDirection("DOWN", verticalMovement);
		} else {
			// move up
			printDirection("UP", verticalMovement);
		}

		int horizontalMovement = Math.abs(princessColPos - botColPos);
		if (princessColPos > botColPos) {
			// right
			printDirection("RIGHT", horizontalMovement);
		} else {
			// left
			printDirection("LEFT", horizontalMovement);
		}

	}

	static void printDirection(String direction, int count) {
		for (int i = 1; i <= count; i++) {
			System.out.println(direction);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m;
		m = in.nextInt();
		String grid[] = new String[m];
		for (int i = 0; i < m; i++) {
			grid[i] = in.next();
		}

		displayPathtoPrincess(m, grid);
	}
}