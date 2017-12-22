package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigDecimal;
import java.util.*;

class HERangeSumDp {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();

		Node A[] = new Node[n + 1]; // for 1 indexing
		double sumTillNow = 0;
		for (int i = 1; i <= n; i++) {
			double value = Double.parseDouble(in.next());
			Node node = new Node();
			node.value = value;
			node.sumTillNow = value + sumTillNow;
			sumTillNow = node.sumTillNow;
			A[i] = node;
		}

		for (int i = 0; i < q; i++) {
			int type = in.nextInt();
			switch (type) {
			case 1:
				int l = in.nextInt();
				int r = in.nextInt();
				int k = in.nextInt();

				
				double sum = 0;
				for (int j = l; j <= r; j++) {
					if (j == 1) {
						sum += A[j].sumTillNow;
					} else {

						int ll = j - k;
						if (ll <= 0) {
							ll = 1;
						}

						sum += getSumInRage(A[ll], A[j]);
					}
				}
				
				BigDecimal stripedVal = new BigDecimal(sum).stripTrailingZeros();
				println(stripedVal.toPlainString());
				break;
			case 2:
				int index = in.nextInt();
				double newSkillValue = in.nextInt();
				double newAddValue = newSkillValue - A[index].value;
				//A[index].sumTillNow += newAddValue;
				for (int p = index; p < A.length; p++) {
					A[p].sumTillNow += newAddValue;
				}
				A[index].value = newSkillValue;
				break;
			}
		}

	}

	static double getSumInRage(Node left, Node right) {
		return right.sumTillNow - (left.sumTillNow - left.value);
	}

	static class Node {
		double sumTillNow;
		double value;
	}

	static void print(String str) {
		System.out.print(str);
	}

	static void println(String str) {
		System.out.println(str);
	}

}
