package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Executors;

public class RangeAddition {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		int tracks = scanner.nextInt();
		HashMap<Integer, ArrayList<Range>> hmList = new HashMap<>();
		for (int i = 1; i <= row; i++) {
			hmList.put(i, null);
		}

		for (int i = 0; i < tracks; i++) {
			int r1 = scanner.nextInt();
			int c1 = scanner.nextInt();
			int c2 = scanner.nextInt();

			Range range = new Range(c1, c2);
			ArrayList<Range> rangeList = hmList.get(r1);
			if (rangeList == null) {
				rangeList = new ArrayList<>();
			}
			rangeList.add(range);
			hmList.put(r1, rangeList);
		}

		for (Integer rowID : hmList.keySet()) {

			ArrayList<Range> rangeList = hmList.get(rowID);
			if (rangeList == null) {
				emptyBlocks += col;
				continue;
			}
			Collections.sort(rangeList, new Comparator<Range>() {

				@Override
				public int compare(Range o1, Range o2) {
					if (o2.c1 > o1.c1) {
						return -10;
					} else {
						return 10;
					}
				}
			});

			for (int i = 1; i < rangeList.size(); i++) {
				Range prevRange = rangeList.get(i - 1);
				Range currentRange = rangeList.get(i);
				if (prevRange.c2 >= currentRange.c1) {
					if (prevRange.c2 < currentRange.c2) {
						// delete both current and previous
						Range newRange = new Range(prevRange.c1, currentRange.c2);
						rangeList.set(i, newRange);
						rangeList.set(i - 1, null);
					} else {
						// delete current
						rangeList.set(i - 1, null);
						rangeList.set(i, prevRange);
					}
				}
			}

			Range prevRange = null;
			for (int i = 0; i < rangeList.size(); i++) {
				Range range = rangeList.get(i);
				if (range != null) {
					if (prevRange == null) {
						prevRange = range;
						emptyBlocks += range.c1 - 1;
						if (i == rangeList.size() - 1) {
							emptyBlocks += col - range.c2;
						}
					} else {
						emptyBlocks += (range.c1 - prevRange.c2) - 1;
						if (i == rangeList.size() - 1) {
							emptyBlocks += col - range.c2;
						}
					}
				}

			}

			hmList.put(rowID, rangeList);
		}
		System.out.println(emptyBlocks);

	}

	static long emptyBlocks;

	static class Range {
		int c1;
		int c2;

		public Range(int c1, int c2) {
			this.c1 = c1;
			this.c2 = c2;
		}
	}
}
