package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Executors;

public class Mix {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		BigInteger firstNumber = new BigInteger(scanner.next());
		BigInteger secondNumber = new BigInteger(scanner.next());

		BigInteger firstNumberDiv = firstNumber.divide(new BigInteger("2"));
		BigInteger secondNumberDiv = secondNumber.divide(new BigInteger("2"));

		BigInteger maxLimit = firstNumberDiv.min(secondNumberDiv);
		BigInteger minLimit = new BigInteger("2");

		
		
		System.out.println(firstNumber.gcd(secondNumber).intValue());
		
		BigInteger count = new BigInteger("1");;
		for (BigInteger i = minLimit; i.compareTo(maxLimit) != 1; i = i.add( BigInteger.ONE)) {
			if (firstNumber.mod(i).equals(BigInteger.ZERO) && secondNumber.mod(i).equals(BigInteger.ZERO)) {
				count = count.add(BigInteger.ONE);
			}
		}

		System.out.println(count.toString());
		
		// HashMap<Integer,String> hm=new HashMap<Integer,String>();
		// Iterator<Entry<Integer, String>> it = hm.entrySet().iterator();
		// Entry<Integer, String> ff= it.next();

	}

	interface one {

		void method();
	}

	private static String isBalancedBrackets(String value) {
		Stack<Character> stack = new Stack<>();
		char upperElement = 0;
		for (int i = 0; i < value.length(); i++) {
			if (!stack.isEmpty()) {
				upperElement = stack.peek();
			}
			stack.push(value.charAt(i));
			if (!stack.isEmpty() && stack.size() > 1) {
				if ((upperElement == '[' && stack.peek() == ']') || (upperElement == '{' && stack.peek() == '}')
						|| (upperElement == '(' && stack.peek() == ')')) {
					stack.pop();
					stack.pop();
				}
			}
		}
		return stack.isEmpty() ? "YES" : "NO";
	}

	interface two {
		void method();
	}

	class x implements one, two {

		@Override
		public void method() {
		}

	}

}
