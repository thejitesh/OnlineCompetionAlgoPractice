package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;

class FibonacciAndGCD {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		
		long A[] = new long[n];
		for (int i = 0; i < n; i++) {
			A[i] = Long.parseLong(scanner.next());
		}

		for (int i = 0; i < q; i++) {
			int L = scanner.nextInt();
			int R = scanner.nextInt();
			double fib[] = new double[(R - L) + 1];
			int count = 0;
			for (int j = L - 1; j < R; j++) {
				double fibValue = getFibonaci(A[j]);
				fib[count] = fibValue;
				count++;
			}
			print(  (int)(   getGCD(fib) % (Math.pow(10, 9) + 7)   ) + "");
		}

		scanner.close();
	}

	static int getGCD(int x, int y) {
		int r = 0, a, b;
		a = (x > y) ? x : y; // a is greater number
		b = (x < y) ? x : y; // b is smaller number

		r = b;
		while (a % b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return r;
	}
	
	
	static double gcd(double x, double y)
	{
		double r;

	    if (x <= 0 || y <= 0)
	        return(0);

	    while ((r = x % y) != 0l)
	    {
	        x = y;
	        y = r;
	    }
	    return(y);
	}

	public static double getGCD(double[] a) {
		double gcd = a[0];
		for (int i = 1; i < a.length; i++) {
			gcd = gcd(gcd, a[i]);
		}
		return gcd;
	}

	static int getFibValueAtIndex(int n) {

		if (n <= 1)
			return n;
		return getFibValueAtIndex(n - 1) + getFibValueAtIndex(n - 2);
	}

	static Scanner in;

	static void initInput() {
		in = new Scanner(System.in);
	}

	static int nextInt() {
		return in.nextInt();
	}

	static String nextLine() {
		return in.nextLine();
	}

	static void print(String str) {
		System.out.println(str);
	}

	static double getFibonaci(long n) {

		double sqrtFive = Math.sqrt(5);

		double first = Math.pow(1 + sqrtFive, n);
		double second = Math.pow(1 - sqrtFive, n);

		double bottom = Math.pow(2, n) * sqrtFive;

		return  ((first - second) / bottom);

	}

}