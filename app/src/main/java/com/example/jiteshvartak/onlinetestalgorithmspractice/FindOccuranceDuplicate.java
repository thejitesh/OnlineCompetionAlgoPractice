package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class FindOccuranceDuplicate {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String inputStrArray[] = new String[N];
		for (int i = 0; i < N; i++) {
			inputStrArray[i] = in.next();
		}

		int Q = in.nextInt();
		HashMap<String, Integer> hmOccurance = new LinkedHashMap<String, Integer>();
		String queryStrArray[] = new String[Q];
		for (int i = 0; i < Q; i++) {
			queryStrArray[i] = in.next();
			hmOccurance.put(queryStrArray[i]+i, 0);
		}
		in.close();

		for (String inputStr : inputStrArray) {
			for (int i = 0; i < queryStrArray.length; i++) {
				String queryStr = queryStrArray[i];
				if (inputStr.length() == queryStr.length() && inputStr.equals(queryStr)) {
					Integer queryStrOccurance = hmOccurance.get(queryStr+i);
					hmOccurance.put(queryStr+i, queryStrOccurance.intValue() + 1);
				}
			}
		}

		for (Integer occurance : hmOccurance.values()) {
			System.out.println(occurance.intValue());
		}

	}

}
