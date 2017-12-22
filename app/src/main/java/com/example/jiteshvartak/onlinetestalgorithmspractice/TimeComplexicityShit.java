package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class TimeComplexicityShit {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		long[] intList = new long[N];
		for (int i = 0; i < M; i++) {
			Calculator sol1 = new Calculator(in.nextInt(), in.nextInt(), in.nextInt());
			intList = sol1.evaluate(intList);
		}
		in.close();
		long maxElement = 0;
		for (long longValue : intList) {
			if (longValue > maxElement) {
				maxElement = longValue;
			}
		}
		System.out.println("maxElement : " + maxElement);

	}

	static class Calculator {
		int a;
		int b;
		int k;

		Calculator(int a, int b, int k) {
			this.a = a;
			this.b = b;
			this.k = k;
		}

		long[] evaluate(long[] list) {
			for (int i = a - 1; i < b; i++) {
				list[i] += 1;
			}
			return list;
		}

	}

}
