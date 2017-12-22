package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class CountSubstrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int n = in.nextInt();
		final int q = in.nextInt();
		final String string = in.next();
		HashMap<String, Integer> hmSubstringsCount = new LinkedHashMap<>();
		for (int a0 = 0; a0 < q; a0++) {
			final int left = in.nextInt();
			final int right = in.nextInt();

			Integer intSubstringsCount = hmSubstringsCount.get(left + "-" + right);
			if (intSubstringsCount != null) {
				System.out.println(intSubstringsCount.intValue());
				continue;
			}

			final int length = (right - left) + 1;
			final String word = string.substring(left, right + 1);
			ArrayList<String> wordOccurances = new ArrayList<String>(n);
			for (int i = 1; i <= length; i++) {
				int startIndex = 0;
				int endIndex = i;
				while (true) {
					String extractedWord = word.substring(startIndex, endIndex);
					if (!wordOccurances.contains(extractedWord)) {
						wordOccurances.add(extractedWord);
					}
					startIndex++;
					endIndex++;
					if (endIndex > length) {
						break;
					}
				}
			}
			System.out.println(wordOccurances.size());
			hmSubstringsCount.put(left + "-" + right, wordOccurances.size());
		}
		in.close();
	}

}
