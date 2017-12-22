package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DivideAddNumber {

	static String onceInATram(int x) {

		x++;
		for (int i = x + 1;; i++) {
			String numStr = x + "";
			int one = Integer.parseInt(numStr.charAt(0) + "");
			int two = Integer.parseInt(numStr.charAt(1) + "");
			int three = Integer.parseInt(numStr.charAt(2) + "");

			int four = Integer.parseInt(numStr.charAt(3) + "");
			int five = Integer.parseInt(numStr.charAt(4) + "");
			int six = Integer.parseInt(numStr.charAt(5) + "");

			int leftSum = one + two + three;
			int rightSum = four + five + six;
			if(leftSum == rightSum){
				return one +""+ two +""+  three +""+four +""+  five +""+  six;
			}
			x++;

		}

	}

	static boolean isSameSum(int sum, String numStr) {

		int lSUm = 0;
		for (int i = 0; i < numStr.length(); i++) {
			lSUm += Integer.parseInt(numStr.charAt(i) + "");
		}

		return sum == lSUm;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		String result = onceInATram(x);
		System.out.println(result);
	}
}
