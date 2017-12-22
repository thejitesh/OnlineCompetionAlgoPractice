package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class CatMouseCatch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int catAPos = in.nextInt();
			int catBPos = in.nextInt();
			int mousePos = in.nextInt();
			int catADistanceFromMouse = Math.abs(mousePos - catAPos);
			int catBDistanceFromMouse = Math.abs(mousePos - catBPos);
			if (catADistanceFromMouse < catBDistanceFromMouse) {
				System.out.println("Cat A");
			}
			else if (catBDistanceFromMouse < catADistanceFromMouse) {
				System.out.println("Cat B");
			} else {
				System.out.println("Mouse C");
			}
		}
		in.close();
	}

}
