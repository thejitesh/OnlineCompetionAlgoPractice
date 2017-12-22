package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.lang.reflect.Array;
import java.util.*;

class ArrayIntervalSubsituteMakeLongSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int a[] = new int[n];
		int si = -1;
		int ei = -1;
		ArrayList<Interval> intervalList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();

			if (a[i] == 1) {
				if (si == -1) {
					si = i;
					if (i == n - 1) {

						intervalList.add(new Interval(si, si, 1));
					}
				} else {
					ei = i;
					if (i == n - 1) {

						intervalList.add(new Interval(si, ei, ei - si + 1));
					}

				}
			} else {
				if (si >= 0) {

					ei = ei <= 0 ? si : ei;

					intervalList.add(new Interval(si, ei, ei - si + 1));
					si = -1;
					ei = -1;
				}
			}
		}

		// ArrayList<Integer> sizeList = new ArrayList<>();
		int currentSize = 0;

		for (int i = 0; i < intervalList.size(); i++) {
			// println("" + intervalList.get(i).size);

			Interval currentInterval = intervalList.get(i);

			if (i == intervalList.size() - 1) {
				// sizeList.add(currentInterval.size);
				if (i > 0) {
					currentSize = currentInterval.size + 1 > currentSize ? currentInterval.size + 1 : currentSize;
				} else {
					currentSize = currentInterval.size > currentSize ? currentInterval.size : currentSize;
				}
			} else {

				Interval nextInterval = intervalList.get(i + 1);
				if (nextInterval.startIndex - currentInterval.endIndex == 2) {
					if (i + 1 != intervalList.size() - 1) {
						int size = currentInterval.size + nextInterval.size + 1;
						// sizeList.add(size);
						currentSize = size > currentSize ? size : currentSize;

					} else {
						int size;
						if (i > 0) {
							size = currentInterval.size + nextInterval.size + 1;
						} else {
							size = currentInterval.size + nextInterval.size;
						}

						// sizeList.add(size);
						currentSize = size > currentSize ? size : currentSize;
					}
				} else {
					int size = currentInterval.size + 1;
					// sizeList.add(size);
					currentSize = size > currentSize ? size : currentSize;
				}

			}

		}

		println(currentSize + "");

	}

	static class Interval {
		int startIndex;
		int endIndex;
		int size;

		public Interval(int startIndex, int endIndex, int size) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.size = size;
		}
	}

	static void print(String str) {
		System.out.print(str);
	}

	static void println(String str) {
		System.out.println(str);
	}

}
