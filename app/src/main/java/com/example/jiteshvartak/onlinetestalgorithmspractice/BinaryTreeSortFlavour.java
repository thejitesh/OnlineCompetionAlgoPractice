package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class BinaryTreeSortFlavour {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int trips = scanner.nextInt();

		for (int x = 0; x < trips; x++) {
			int totalMoney = scanner.nextInt();
			int nFlavours = scanner.nextInt();
			Flavour flavours[] = new Flavour[nFlavours];
			for (int y = 0; y < nFlavours; y++) {
				Flavour flavour = new Flavour();
				flavour.cost = scanner.nextInt();
				flavour.index = y + 1;
				flavours[y] = flavour;
			}

			Arrays.sort(flavours, new Comparator<Flavour>() {
				@Override
				public int compare(Flavour o1, Flavour o2) {
					if (o1.cost > o2.cost) {
						return 1;
					}
					return -1;
				}
			});

			for (int i = 0; i < flavours.length; i++) {
				Flavour flavour = flavours[i];
				Flavour flavour2 = getCorrespondingFlavour(totalMoney, flavour, flavours, i);
				if (flavour2 != null) {
					if (flavour.index < flavour2.index) {
						System.out.print(flavour.index);
						System.out.print(" " + flavour2.index + "\n");
					} else {
						System.out.print(flavour2.index);
						System.out.print(" " + flavour.index + "\n");
					}

					break;
				}
			}

		}

	}

	private static Flavour getCorrespondingFlavour(int totalMoney, Flavour selectedFlavour, Flavour[] flavours,
			int currentSelectedIndex) {

		if (flavours.length == 1) {
			return flavours[0];
		}
		if (selectedFlavour.cost > totalMoney) {
			return null;
		}

		int requiredFlavourWithCost = totalMoney - selectedFlavour.cost;

		int leftIndex = currentSelectedIndex + 1;
		int rightIndex = flavours.length - 1;
		int midIndex = (leftIndex + rightIndex) / 2;

		while (true) {

			Flavour flavourLeft = flavours[leftIndex];
			Flavour flavourMid = flavours[midIndex];
			Flavour flavourRight = flavours[rightIndex];

			if (flavourLeft.cost == requiredFlavourWithCost) {
				return flavourLeft;
			} else if (flavourMid.cost == requiredFlavourWithCost) {
				return flavourMid;
			} else if (flavourRight.cost == requiredFlavourWithCost) {
				return flavourRight;
			}

			if (leftIndex == rightIndex || requiredFlavourWithCost < flavourLeft.cost
					|| requiredFlavourWithCost > flavourRight.cost) {
				return null;
			}

			if (requiredFlavourWithCost > flavourMid.cost) {
				leftIndex = midIndex + 1;
			} else {
				rightIndex = midIndex - 1;
			}

			midIndex = (leftIndex + rightIndex) / 2;
		}

		// return null;
	}

	static class Flavour {
		int cost;
		int index;
	}

}