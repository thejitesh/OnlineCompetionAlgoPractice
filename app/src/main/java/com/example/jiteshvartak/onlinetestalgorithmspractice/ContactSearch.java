package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ContactSearch {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		ArrayList<String> lst = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String command = scanner.next();
			if ("add".equalsIgnoreCase(command)) {
				lst.add(scanner.next());
			} else if ("find".equalsIgnoreCase(command)) {
				String findPattern = scanner.next();
				int occuranceCount = 0;
				//
				// Pattern p = Pattern.compile("(?i)^" + findPattern + ".*");//
				// .
				// // represents
				// // single
				// // character

				for (int j = 0; j < lst.size(); j++) {

					String giveString = lst.get(j);
					if (giveString.length() >= findPattern.length()) {

						String extractedStr = giveString.substring(0, findPattern.length() );
						if (extractedStr.equalsIgnoreCase(findPattern)) {
							occuranceCount++;
						}
					}

				}
				System.out.println(occuranceCount);
			}

		}

	}

}