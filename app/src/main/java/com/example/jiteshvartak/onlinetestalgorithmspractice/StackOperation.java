package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class StackOperation {
	public static void main(String[] args) {

		Stack<Node> stack = new Stack<>();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int type = scanner.nextInt();
			switch (type) {
			case 1:
				Node node = new Node();
				node.value = scanner.nextInt();
				node.max = node.value > max ? node.value : max;
				stack.push(node);
				break;

			case 2:
				if (!stack.isEmpty()) {
					stack.pop();
				}

				if (!stack.isEmpty()) {
					max = stack.peek().max;
				} else {
					max = Integer.MIN_VALUE;
				}

				break;

			case 3:
				if (!stack.isEmpty()) {
					print(stack.peek().max + "");
				}
				break;
			}
		}
		
		
		
	
	}

	static void print(String str) {
		System.out.println(str);
	}

	static class Node {

		int value;
		int max;
	}

}