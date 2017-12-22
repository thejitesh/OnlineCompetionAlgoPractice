package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.io.*;
import java.util.*;

public class AAA {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();

		for (int ar_i = 0; ar_i < Q; ar_i++) {

			int n = in.nextInt();
			double[] black_3 = new double[n + 1];
			double[] black_count = new double[n + 1];

			black_3[1] = 1;
			black_count[1] = 1;

			if(n==1){
				System.out.println("5");
			}
			for (int i = 2; i <= n; i++) {

				black_3[i] = black_3[i - 1] * 3;

				black_count[i] = black_count[i - 1] + black_3[i];

				if (i == n) {
					
					double result = (black_count[i]  *4) + 1;
					double modBy = Math.pow(10, 9) + 7;
					double finalResult = result%modBy;
					String str = String.format("%.0f", finalResult);
					
					System.out.println(str);
				}
			}
		}
		in.close();
	}

}