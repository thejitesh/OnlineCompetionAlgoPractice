package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class NodeTraversal {

	public static void main(String[] args) {

	}

	boolean hasCycle(Node head) {

		if (head == null || head.next == null) {
			return false;
		}
		
		
		
		HashMap<Node , Integer> traversedNodeList = new HashMap<>();

		while (head != null) {
			
			Integer traversedNode = traversedNodeList.get(head);
			if (traversedNode!= null) {
				return true;
			}
			traversedNodeList.put(head , head.data);
			
			head = head.next;
		}

		return false;
	}

	class Node {
		int data;
		Node next;
	}

}
