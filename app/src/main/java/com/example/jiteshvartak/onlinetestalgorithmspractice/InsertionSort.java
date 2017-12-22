package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Executors;

public class InsertionSort {

	public static void insertionSortPart2(int[] arr) {

		int chooseIndex = 1;
		while (chooseIndex < arr.length) {
			int chooseIndexValue = arr[chooseIndex];
			for (int i = chooseIndex - 1; i >= 0; i--) {
				if (arr[i] > chooseIndexValue) {
					arr[i + 1] = arr[i];
					if (i == 0) {
						arr[i] = chooseIndexValue;
					}
				}else{
					arr[i+1] =chooseIndexValue;
					break;
				}
			}
			chooseIndex++;
			printArray(arr);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSortPart2(ar);
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
