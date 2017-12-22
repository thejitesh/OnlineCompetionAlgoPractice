package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class AIGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int games = in.nextInt();

		for (int i = 0; i < games; i++) {
			int n = in.nextInt();
			int a[] = new int[n];
			Node formatedData[] = new Node[n];
			for (int j = 0; j < n; j++) {
				a[j] = in.nextInt();
				Node node = new Node();
				node.index = j;
				node.value = a[j];
				formatedData[j] = node;
			}

			Arrays.sort(formatedData, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					if (o1.value > o2.value) {
						return -10;
					}

					return 10;
				}
			});

			print(getWinner(a, formatedData));

		}

		in.close();

	}

	static class Node {
		int index;
		int value;
	}

	private static String getWinner(int[] a, Node[] formatedData) {
		if (a.length == 1) {
			return "BOB";
		}

		int formatedIndex = 0;
		int endIndex = formatedData[formatedIndex].index;
		boolean isBobWin = true;
		while (true) {
			if (endIndex == 0) {
				break;
			}

			for (int i = formatedIndex + 1; i < formatedData.length; i++) {
				if (endIndex > formatedData[i].index) {
					endIndex = formatedData[i].index;
					formatedIndex = i;
					break;
				}
			}
			isBobWin = !isBobWin;
		}

		return isBobWin ? "BOB" : "ANDY";
	}

	static void print(String str) {
		System.out.println(str);
	}

}