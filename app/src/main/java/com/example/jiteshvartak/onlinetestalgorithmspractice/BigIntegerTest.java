package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;

public class BigIntegerTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int firstNumber = in.nextInt();
		int secondNumber = in.nextInt();
		int N = in.nextInt();
		in.close();
		BigInteger longFibboSqaresArray[] = new BigInteger[N];
		longFibboSqaresArray[0] = new BigInteger(firstNumber + "");
		longFibboSqaresArray[1] = new BigInteger(secondNumber + "");

		for (int i = 2; i < N; i++) {
			longFibboSqaresArray[i] = (longFibboSqaresArray[i - 1].multiply(longFibboSqaresArray[i - 1])).add(longFibboSqaresArray[i - 2]);
		}

		System.out.println(longFibboSqaresArray[N - 1]);
	}

}
