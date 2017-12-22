package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.io.*;
import java.util.*;

public class MergeSort {

	static int castleTowers(int n, Integer[] ar) {
		sort_Merge(ar);
		int maxi = ar[n-1];
		int cnt = 1;
		for (int i = n-2; i >=0; i--) {
			if (maxi == ar[i]) {
				cnt += 1;
			} else {
				break;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] ar = new Integer[n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextInt();
		}
		int result = castleTowers(n, ar);
		System.out.println(result);
		in.close();
	}
	
	
	
	
	
	
	private static Integer[] array;
	private static Integer[] tempMergArr;
	private static int length;

	public static void sort_Merge(Integer inputArr[]) {
		array = inputArr;
		length = inputArr.length;
		tempMergArr = new Integer[length];
		doMergeSort(0, length - 1);
	}

	private static void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private static void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}
}