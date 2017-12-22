package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class RecursionGraphDuplicatePath {
	static Node nodes[];
	// static ArrayList<Node> path = new ArrayList<>();
	static ArrayList<Node> traversedPath = new ArrayList<>();
	static ArrayList<int[]> malePathList = new ArrayList<>();
	static ArrayList<int[]> femalePathList = new ArrayList<>();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int q = in.nextInt();
		nodes = new Node[n + 1];

		
		
		// edge
		for (int a0 = 0; a0 < m; a0++) {

			int n1 = in.nextInt();
			int n2 = in.nextInt();

			Node node1 = nodes[n1];
			Node node2 = nodes[n2];

			if (node1 == null) {
				node1 = new Node();
				node1.id = n1;
			}

			if (node2 == null) {
				node2 = new Node();
				node2.id = n2;
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

		for (int ii = 0; ii < q; ii++) {

			int u = in.nextInt();
			int v = in.nextInt();
			int w = in.nextInt();

			checkForNode(nodes[w], nodes[w], nodes[u], nodes[v]);
			boolean isUniquePathFound = false;

			for (int i = 0; i < malePathList.size(); i++) {
				int[] malePath = malePathList.get(i);

				for (int j = 0; j < femalePathList.size(); j++) {
					int[] femalePath = femalePathList.get(j);

					if (isUnique(malePath, femalePath)) {
						isUniquePathFound = true;
						break;
					}
				}

				if (isUniquePathFound) {
					break;
				}
			}

			if (isUniquePathFound) {
				println("YES");
			} else {
				println("NO");
			}
			traversedPath.clear();
			malePathList.clear();
			femalePathList.clear();

		}

		in.close();
	}

	static boolean isUnique(int[] malePath, int[] femalePath) {

		for (int i = 0; i < malePath.length; i++) {
			int maleNode = malePath[i];

			for (int j = 0; j < femalePath.length; j++) {
				int femaleNode = femalePath[j];
				if (maleNode == femaleNode) {
					return false;
				}
			}
		}

		return true;
	}

	static Node checkForNode(Node dukan, Node sushiDukan, Node male, Node female) {

		if (traversedPath.contains(dukan)) {
			return null;
		}

		if (male.id == dukan.id) {

			int list[] = new int[traversedPath.size() == 0 ? 1 : traversedPath.size()];
			for (int i = 1; i < traversedPath.size(); i++) {
				list[i - 1] = traversedPath.get(i).id;
			}
			list[list.length == 0 ? 0 : list.length - 1] = male.id;
			Arrays.sort(list);
			malePathList.add(list);

		} else if (female.id == dukan.id) {

			int list[] = new int[traversedPath.size() == 0 ? 1 : traversedPath.size()];
			for (int i = 1; i < traversedPath.size(); i++) {
				list[i - 1] = traversedPath.get(i).id;
			}
			list[list.length == 0 ? 0 : list.length - 1] = female.id;
			Arrays.sort(list);
			femalePathList.add(list);
		}

		traversedPath.add(dukan);

		for (int i = 0; i < dukan.adjucentNodes.size(); i++) {
			checkForNode(nodes[dukan.adjucentNodes.get(i)], sushiDukan, male, female);
		}
		traversedPath.remove(dukan);
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
