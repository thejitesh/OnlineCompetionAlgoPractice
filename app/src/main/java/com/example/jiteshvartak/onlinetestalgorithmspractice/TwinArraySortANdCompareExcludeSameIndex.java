package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class TwinArraySortANdCompareExcludeSameIndex {

	static int twinArrays(Node[] ar1, Node[] ar2) {

		Comparator<Node> comparator = new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {

				if (o1.value > o2.value) {
					return 10;
				} else if (o1.value < o2.value) {
					return -10;
				}
				return 0;
			}
		};

		Arrays.sort(ar1, comparator);

		Arrays.sort(ar2, comparator);

		if (ar1[0].index != ar2[0].index) {
			return ar1[0].value + ar2[0].value;
		} else {
			return Math.min(ar1[0].value + ar2[1].value, ar1[1].value + ar2[0].value);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node[] ar1 = new Node[n];
		for (int ar1_i = 0; ar1_i < n; ar1_i++) {
			Node node = new Node();
			node.index = ar1_i;
			node.value = Integer.parseInt(in.next().trim());
			ar1[ar1_i] = node;

		}
		Node[] ar2 = new Node[n];
		for (int ar2_i = 0; ar2_i < n; ar2_i++) {
			Node node = new Node();
			node.index = ar2_i;
			node.value = Integer.parseInt(in.next().trim());
			ar2[ar2_i] = node;
		}
		int result = twinArrays(ar1, ar2);
		System.out.println(result);
	}

	static void print(String str) {
		System.out.println(str);
	}

	static class Node {
		int index;
		int value;

	}

}