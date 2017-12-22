package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class HourTree {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int matruxDimen = 6;
		 int[][] a = new int[matruxDimen][matruxDimen];
		
		 for (int i = 0; i < matruxDimen; i++) {
		 for (int j = 0; j < matruxDimen; j++) {
		 a[j][i] = in.nextInt();
		 }
		 }
		 in.close();
		
		 int max = -1000000;
		 for (int i = 0; i <= matruxDimen - 3; i++) {
		 for (int j = 0; j <= matruxDimen - 3; j++) {
		
		 HourTree123 h = new HourTree123(a[i][j], a[i+1][j], a[i+2][j], a[i+1][j+1],
		 a[i][j+2], a[i+1][j+2], a[i+2][j+2]);
		
		 int addValue = h.add();
		 if (addValue > max) {
		 max = addValue;
		 }
		
		 }
		 }
		
		
		 System.out.println(max);

		


	}

	static class HourTree123 {
		int a, b, c;
		int d;
		int e, f, g;

		public HourTree123(int a, int b, int c, int d, int e, int f, int g) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
			this.f = f;
			this.g = g;

		}

		int add() {
			return a + b + c + d + e + f + g;
		}
	}
}
