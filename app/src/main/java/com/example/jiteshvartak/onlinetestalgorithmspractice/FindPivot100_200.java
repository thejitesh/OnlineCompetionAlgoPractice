package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class FindPivot100_200 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int arr[] = new int[201];
		int pivot = 0;
		int A = scanner.nextInt();
		for (int i = 0; i < A; i++) {

			int num = scanner.nextInt();
			if (i == 0) {
				arr[100] -= 1;
				pivot = num;
			} else {

				if (pivot > num) {
					arr[100 - (pivot - num)] -= 1;
				} else {
					arr[100 + (num - pivot)] -= 1;
				}
			}
		}
		int B = scanner.nextInt();

		for (int i = 0; i < B; i++) {
			int num = scanner.nextInt();
			if (pivot > num) {
				arr[100 - (pivot - num)] += 1;
			} else {
				arr[100 + (num - pivot)] += 1;
			}
		}

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > 0) {
				if (i > 100) {
					System.out.print((i - 100) + pivot + " ");
				} else {
					System.out.print(pivot - (100 - i) + " ");
				}

			}
		}

	}

	static void print(String str) {
		System.out.println(str);
	}

}