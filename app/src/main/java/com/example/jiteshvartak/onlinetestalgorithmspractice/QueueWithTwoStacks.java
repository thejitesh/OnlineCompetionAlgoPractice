package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class QueueWithTwoStacks {
	public static void main(String[] args) {

		Stack<Integer> inbox = new Stack<>();
		Stack<Integer> outbox = new Stack<>();

		Scanner scanner = new Scanner(System.in);
		int q = scanner.nextInt();
		for (int i = 0; i < q; i++) {
			int type = scanner.nextInt();
			switch (type) {
			case 1:
				// enqueue
				int element = scanner.nextInt();
				inbox.push(element);
				break;

			case 2:
				// dequeue
				if (outbox.isEmpty()) {
					while (!inbox.isEmpty()) {
						outbox.push(inbox.pop());
					}
				}
				if (!outbox.isEmpty()) {
					outbox.pop();
				}
				break;

			case 3:
				// print
				if (outbox.isEmpty()) {
					while (!inbox.isEmpty()) {
						outbox.push(inbox.pop());
					}
				}

				if (!outbox.isEmpty()) {
					print(outbox.get(outbox.size() - 1).intValue() + "");
				}
				break;
			}
		}

	}

	static void print(String str) {
		System.out.println(str);
	}

}