package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TotalPurchaseCount {
	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt(), k = stdin.nextInt();
		int prices[] = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = stdin.nextInt();
		}

		Arrays.sort(prices);
		int answer = 0;
		int totalPurchased = 0;
		for (int i = 0; i < prices.length; i++) {

			totalPurchased += prices[i];
			if(totalPurchased>=k){
				break;
			}
			answer++;
		}

		// Compute the final answer from n,k,prices
		System.out.println(answer);
	}

}