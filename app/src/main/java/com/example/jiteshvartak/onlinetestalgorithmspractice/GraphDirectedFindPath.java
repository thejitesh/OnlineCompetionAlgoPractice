package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class GraphDirectedFindPath {

	static Node nodes[];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int x = 0; x < t; x++) {
			int n = in.nextInt();
			nodes = new Node[n + 1];

			for (int i = 1; i <= n; i++) {
				nodes[i] = new Node();
				nodes[i].id = i;
			}

			int m = in.nextInt();
			for (int i = 1; i <= m; i++) {
				int cn = in.nextInt();
				int nn = in.nextInt();
				Edge edge = new Edge(cn, nn);
				nodes[cn].edgeList.add(edge);
			}

			for (int i = 1; i < nodes.length; i++) {

				Node startNode = nodes[i];
				visitedEdge.clear();
				check(startNode, null);
			}
			print("" + path);
			path = 0;

		}

		in.close();

	}

	static ArrayList<String> visitedEdge = new ArrayList<String>();
	static int path = 0;

	static int check(Node startNode, Node nodeToConsider) {

		if (nodeToConsider == null) {
			nodeToConsider = startNode;
		}

		for (int j = 0; j < nodeToConsider.edgeList.size(); j++) {
			Edge edge = nodeToConsider.edgeList.get(j);

			if (!visitedEdge.contains(edge.current + "-" + edge.next)) {
				visitedEdge.add(edge.current + "-" + edge.next);

				if (edge.next == startNode.id) {
					path++;
					visitedEdge.remove(edge.current + "-" + edge.next);
					return edge.current;
				} else {
					int id = check(startNode, nodes[edge.next]);
					if (id > 0) {
						if (edge.current != startNode.id) {
							visitedEdge.remove(edge.current + "-" + edge.next);
							return edge.current;
						} else {
							visitedEdge.remove(edge.current + "-" + edge.next);
						}
					}
				}
			}
		}

		return -1;
	}

	static class Node {
		int id;
		ArrayList<Edge> edgeList = new ArrayList<>();
	}

	static class Edge {
		int current;
		int next;

		public Edge(int current, int next) {
			this.current = current;
			this.next = next;
		}
	}

	static void print(String str) {
		System.out.print(str);
	}

	static void println(String str) {
		System.out.println(str);
	}

}
