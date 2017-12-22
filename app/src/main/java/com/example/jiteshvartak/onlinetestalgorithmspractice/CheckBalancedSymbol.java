package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class CheckBalancedSymbol {

	public static void main(String[] args) {

		if(new CheckBalancedSymbol().isBalanced("(())")){
			System.out.println("Balanced");
		}else{
			System.out.println("Not Balanced");
		}

	}

	HashMap<String, String> openingClosingBraces = new HashMap<>();

	public boolean isBalanced(String expression) {

		if (expression == null || expression.length() == 0 || (expression.length() % 2) != 0) {
			return false;
		}

		openingClosingBraces.put(")", "(");
		openingClosingBraces.put("}", "{");
		openingClosingBraces.put("]", "[");

		for (int i = 0; i < expression.length(); i++) {
			char character = expression.charAt(i);
			if (isClosingChar(character)) {
				int expectedOpeningBracketPosition = i - 1;
				if (expectedOpeningBracketPosition >= 0) {
					char openingBracket = expression.charAt(expectedOpeningBracketPosition);
					char actualOpeningBracket = openingClosingBraces.get(character+"").charAt(0);
					if (openingBracket == actualOpeningBracket) {
						String expression1 = expression.substring(0,expectedOpeningBracketPosition);
						String expression2 = expression.substring(i+1);
						expression = expression1 + expression2;
						i = expectedOpeningBracketPosition-1;
						continue;
					}
				}
				return false;
			}
		}
		return expression.isEmpty();
	}

	boolean isOpeningChar(char character) {
		return openingClosingBraces.containsValue(character+"");
	}

	boolean isClosingChar(char character) {
		return openingClosingBraces.containsKey(character+"");
	}
}
