package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class DiceRoll {


	public static void main(String[] args) {

		ArrayList<String> dd= new ArrayList<String>();
		
		Scanner scanner = new Scanner(System.in);
		int intNoOfInputs = scanner.nextInt();

		final Node nodeStart = Node.getObject(1);
		final Node nodeEnd = Node.getObject(100);

		for (int i = 0; i < intNoOfInputs; i++) {
			BoardMagic[] boxesList = new BoardMagic[100];
			int intNoOfLadders = scanner.nextInt();
			for (int j = 0; j < intNoOfLadders; j++) {
				int intStartIndexLadder = scanner.nextInt();
				int intEndIndexLadder = scanner.nextInt();
				boxesList[intStartIndexLadder] = new Ladder(intStartIndexLadder, intEndIndexLadder);
			}

			int intNoOfSnakes = scanner.nextInt();
			for (int j = 0; j < intNoOfSnakes; j++) {
				int intStartIndexSnake = scanner.nextInt();
				int intEndIndexSnake = scanner.nextInt();
				boxesList[intStartIndexSnake] = new Snake(intStartIndexSnake, intEndIndexSnake);
			}

			for (int j = 99; j >= 0; j--) {
				BoardMagic boardMagic = boxesList[j];
				if (boardMagic != null && boardMagic instanceof Ladder) {
					int countRollOut = 0;
				}
			}

		}

		scanner.close();
	}

	static int getRollOutCOunt(Node sourceNode, Node destinationNode, BoardMagic[] boxesList) {
		int rollCount = 0;
		while (sourceNode.mPosition != destinationNode.mPosition) {
			int newIndex = sourceNode.mPosition + 6;
			if (newIndex > destinationNode.mPosition) {
				rollCount++;
				break;
			}
			while (boxesList[newIndex] != null && boxesList[newIndex] instanceof Snake) {
				newIndex--;
			}
			sourceNode.mPosition = newIndex;
			rollCount++;
		}

		return rollCount;

	}

	static class Node {
		int mPosition;

		private Node(int position) {
			this.mPosition = position;
		}

		static Node getObject(int intPosition) {
			return new Node(intPosition);
		}
	}

	static class BoardMagic {
		Node mHeadNode;
		Node mTailNode;

		BoardMagic(int start, int end) {
			mHeadNode = Node.getObject(start);
			mTailNode = Node.getObject(end);
		}
	}

	static class Ladder extends BoardMagic {

		Ladder(int start, int end) {
			super(start, end);
		}

	}

	static class Snake extends BoardMagic {

		Snake(int start, int end) {
			super(start, end);
		}
	}

}
