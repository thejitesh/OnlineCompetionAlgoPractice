package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ServiceLane {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int T = scanner.nextInt();
		int laneWidth[] = new int[N];
		for (int i = 0; i < N; i++) {
			laneWidth[i] = scanner.nextInt();
		}

		for (int i = 0; i < T; i++) {
			int startSegemet = scanner.nextInt();
			int endSegemet = scanner.nextInt();
			int minWidthVehicle = -1;
			for (int j = startSegemet; j <=endSegemet; j++) {
				if (j == startSegemet) {
					minWidthVehicle = laneWidth[j];
				} else {
					minWidthVehicle = laneWidth[j] < minWidthVehicle ? laneWidth[j] : minWidthVehicle;
				}
			}
			System.out.println(minWidthVehicle);
		}
		scanner.close();
	}
}