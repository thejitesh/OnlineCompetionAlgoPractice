package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Executors;

public class CharacherMatch {

	public static void main(String[] args) {

		final char MATCH_CHARAS[] = "hackerrank".toCharArray();

		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			char chars[] = s.toCharArray();

			int matchIndex = 0;

			for (int i = 0; i < chars.length; i++) {

				if (MATCH_CHARAS[matchIndex] == chars[i]) {
					matchIndex++;
					if (matchIndex >= MATCH_CHARAS.length) {
						break;
					}
				}
			}
			
			
			if (matchIndex >= MATCH_CHARAS.length) {
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}

	}

	abstract class first {

		final int a = 10;

		final void test() {

		}
	}

	class second extends first {

		void ddd() {
			// a++;
		}
	}
}
