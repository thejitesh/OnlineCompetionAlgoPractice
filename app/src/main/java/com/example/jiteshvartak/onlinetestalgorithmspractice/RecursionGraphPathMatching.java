package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RecursionGraphPathMatching {
	static Node nodes[];
	static ArrayList<Node> path = new ArrayList<>();
	static HashMap<Node, Node> traversedPath = new HashMap<>();
	static String strFind;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int q = Integer.parseInt(input[1]);

		String str = in.nextLine();
		strFind = in.nextLine();

		nodes = new Node[n + 1];

		// edges
		for (int i = 1; i <= n - 1; i++) {

			int n1 = in.nextInt();
			int n2 = in.nextInt();

			Node node1 = nodes[n1];
			Node node2 = nodes[n2];

			if (node1 == null) {
				node1 = new Node();
				node1.id = n1;
				node1.c = str.charAt(n1 - 1);
			}

			if (node2 == null) {
				node2 = new Node();
				node2.id = n2;
				node2.c = str.charAt(n2 - 1);
			}

			if (!node1.adjucentNodes.contains(n2)) {
				node1.adjucentNodes.add(n2);
			}

			if (!node2.adjucentNodes.contains(n1)) {
				node2.adjucentNodes.add(n1);
			}

			nodes[n1] = node1;
			nodes[n2] = node2;
		}

		for (int i = 0; i < q; i++) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();

			checkForNode(nodes[n1], nodes[n2]);
			path.add(nodes[n1]);
			String strConstruct = "";
			for (int j = path.size() - 1; j >= 0; j--) {

				strConstruct += path.get(j).c;
				// print("" + path.get(j).id + "-->");
			}

			Pattern pattern = Pattern.compile(strFind);
			Matcher matcher = pattern.matcher(strConstruct);

			int matchCount = 0;
			boolean found = matcher.find();
			while (found) {
				matchCount += 1;
				found = matcher.find(matcher.start() + 1);
			}

			System.out.println(matchCount); // prints 3

			traversedPath.clear();
			path.clear();
		}

		in.close();
	}

	static Node checkForNode(Node current, Node dest) {

		if (current.id == dest.id) {
			return current;
		}

		if (traversedPath.get(current) != null) {
			return null;
		}
		traversedPath.put(current, current);

		for (int i = 0; i < current.adjucentNodes.size(); i++) {

			Node foundNode = checkForNode(nodes[current.adjucentNodes.get(i)], dest);
			if (foundNode != null) {
				path.add(foundNode);
				return current;
			}

		}

		return null;

	}

	static void print(String str) {
		System.out.print(str);
	}

	static void println(String str) {
		System.out.println(str);
	}

	static class Node {
		int id;
		char c;
		ArrayList<Integer> adjucentNodes = new ArrayList<>();
	}
}