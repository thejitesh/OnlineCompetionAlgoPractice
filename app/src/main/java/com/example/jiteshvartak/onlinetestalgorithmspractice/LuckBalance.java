package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class LuckBalance {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();

		int totalLuckBalance = 0;
		ArrayList<Integer> impContentLuck = new ArrayList<>();

		for (int i = 1; i <= N; i++) {

			int L = in.nextInt();
			int T = in.nextInt();

			switch (T) {
			case 0:
				totalLuckBalance += L;
				break;
			case 1:
				impContentLuck.add(L);
				break;
			}
		}

		Collections.sort(impContentLuck, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {

				if (o1.intValue() < o2.intValue()) {
					return 10;
				}
				return -10;
			}
		});

		for (int i = 0; i < impContentLuck.size(); i++) {
			int luck = impContentLuck.get(i).intValue();
			if (K > 0) {
				totalLuckBalance += luck;
				K--;
			} else {
				totalLuckBalance -= luck;
			}
		}

		print(totalLuckBalance + "");
		in.close();

	}

	static void print(String str) {
		System.out.println(str);
	}

}