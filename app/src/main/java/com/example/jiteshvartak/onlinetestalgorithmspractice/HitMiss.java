package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.io.*;
import java.util.*;

public class HitMiss {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int K = Integer.parseInt(line[1]);
			char[][] A = new char[N][N];
			for (int i_A = 0; i_A < N; i_A++) {
				String[] arr_A = br.readLine().split(" ");
				for (int j_A = 0; j_A < arr_A.length; j_A++) {
					A[i_A][j_A] = arr_A[j_A].charAt(0);
				}
			}
			
			

			int out_ = solution(A, K, N);
			System.out.println(out_);
			System.out.println("");
		}

		wr.close();
		br.close();
	}

	static int solution(char[][] A, int K, int N) {

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				boolean isFound = false;
				char ch = A[i][j];
				if (ch == 'T') {
					for (int x = 1; x <= K; x++) {
						int leftSide = j - x;
						if (leftSide >= 0) {
							if (A[i][leftSide] == 'P') {
								count++;
								isFound = true;
								A[i][leftSide] = 'X';
								break;
							}
						}

					}

					if (isFound) {
						continue;
					}

					for (int x = 1; x <= K; x++) {
						int rightSide = j + x;
						if (rightSide < N) {
							if (A[i][rightSide] == 'P') {
								count++;
								isFound = true;
								A[i][rightSide] = 'X';
								break;
							}
						}
					}

					if (isFound) {
						continue;
					}

				}
			}
		}
		return count;
	}
}