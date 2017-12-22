package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Test {

	// 5 4
	// 10023

	static int getFact(int num) {
		if (num == 0 || num == 1) {
			return 1;
		}
		int fact = 1;
		for (int i = num; i > 0; i--) {
			fact *= i;
		}
		return fact;
	}

	static int getCount(String bin) {
		int count = 0;
		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

	static int getSum(String nStr) {

		int sum = 0;
		for (int i = 0; i < nStr.length(); i++) {
			sum += Integer.parseInt(nStr.charAt(i) + "");
		}
		return sum;
	}

	public static void main(String args[]) {

		String S = "Jitesh";
		
		System.out.println(Integer.toUnsignedString(~Integer.parseInt("1"),2));

		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");

		// 97
		for (int i = 0; i < S.length(); i++) {

			String str = ((int) S.charAt(i)) >= 97 ? (S.charAt(i) + "").toUpperCase()
					: (S.charAt(i) + "").toLowerCase();
			System.out.print(str);
		}

		String str = "48 65 6C 6C 6F 20 77 6F 72 6C 64 21";

		int n = 3;
		String nStr = n + "";
		int sum = 0;
		while (nStr.length() != 1) {
			sum += getSum(nStr);
			nStr = sum + "";
		}

		// System.out.println(""+ (N==1? "1": (((N * N) * 2) + (N-2)*((N*N -
		// (N-2)*(N-2))))));
		// System.out.print("----- ");

		String bin = Integer.toBinaryString(n);
		int reqCount = getCount(bin);

		for (int i = n + 1;; i++) {

			String binGotStr = Integer.toBinaryString(i);
			int binGot = getCount(binGotStr);
			if (binGot == reqCount) {
				System.out.println("" + i);
				break;
			}

		}

		String piStr = "14159265358979323846";
		float interval = 15;
		String strInterval = ((int) interval) + "";

		for (int i = 0; i < piStr.length(); i += strInterval.length()) {
			String retStr = piStr.substring(i, i + strInterval.length());
			int subStrInt = Integer.parseInt(retStr);
			if (interval - subStrInt <= 0) {
				// System.out.print(""+((i)*strInterval.length()));
				break;
			}

		}
		piStr.indexOf(interval + "");

		// System.out.print(getFact(5)+"");
		int H = 11;
		int start = 1;

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= start; j++) {
				if (j == 1 || j == start) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
			if (i <= H / 2) {
				start = start + 2;
			} else {
				start = start - 2;
			}

		}

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			int value = in.nextInt();
			a[i] = value;
		}
		Arrays.sort(a);

		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}
		//
		// Scanner in = new Scanner(System.in);
		// int N = in.nextInt();
		// String SCR = in.next();
		// HashMap<String,ArrayList<String>> hm = new HashMap<>();
		// for (int i = 0; i < N; i++) {
		// String ACC = in.next();
		// ArrayList<String> strList = hm.get(ACC.charAt(0)+"");
		// if(strList==null){
		// strList= new ArrayList<>();
		// }
		// strList.add(ACC);
		// hm.put(ACC.charAt(0)+"", strList);
		//
		// }
		//
		// ArrayList<String> LargestSize;
		// Set<String> strset = hm.keySet();
		// for(String key : strset){
		// if(LargestSize==null){
		// LargestSize = hm.get(strset);
		// }else{
		//
		// if( hm.get(strset).size()>LargestSize.size()){
		// LargestSize = hm.get(strset);
		// }
		// }
		// }
		//
		//
		// System.out.println(LargestSize.get(0));

		// String S = "Abcde fghij klmno ";
		// int arr[] = new int[26];
		// S = S.toLowerCase();
		// for (int i = 0; i < S.length(); i++) {
		//
		// if(S.charAt(i) >=97 && S.charAt(i) <=122 ){
		// arr[S.charAt(i) - 'a']++;
		// }
		//
		// }
		// boolean isZeroOcc = false;
		// for(int i=0;i<26;i++){
		// if(arr[i]==0){
		// isZeroOcc = true;
		// break;
		// }
		// }
		// if(isZeroOcc){
		// System.out.println("false");
		// }else{
		// System.out.println("true");
		// }

		// Scanner in = new Scanner(System.in);
		int width = in.nextInt();
		int height = in.nextInt();
		Point.gridWidth = width;
		Point.gridHeight = height;
		int grid[][] = new int[height][width];
		int newgrid[][] = new int[height][width];

		for (int i = 0; i < height; i++) {
			String line = in.next();
			line = line.trim();
			for (int j = 0; j < line.length(); j++) {
				grid[i][j] = Integer.parseInt(line.charAt(j) + "");
				newgrid[i][j] = 0;
			}
		}

		for (int j = 0; j < height; j++) {

			for (int i = 0; i < width; i++) {

				ArrayList<Point> pointsList = new ArrayList<>();
				Point leftTop = new Point(i - 1, j - 1);
				Point top = new Point(i - 1, j);
				Point rightTop = new Point(i - 1, j + 1);

				Point left = new Point(i, j - 1);
				Point right = new Point(i, j + 1);

				Point bottomLeft = new Point(i + 1, j - 1);
				Point bottom = new Point(i + 1, j);
				Point bottomRight = new Point(i + 1, j + 1);

				pointsList.add(leftTop);
				pointsList.add(top);
				pointsList.add(rightTop);

				pointsList.add(left);
				pointsList.add(right);

				pointsList.add(bottomLeft);
				pointsList.add(bottom);
				pointsList.add(bottomRight);

				// Live:
				// <2 : die
				// 2 - 3 : live
				// >3 : die
				//
				// Dead
				// ==3 : live
				int liveNeighbours = 0;
				for (int x = 0; x < pointsList.size(); x++) {

					Point point = pointsList.get(x);
					if (point.isInsideGrid()) {
						if (grid[point.row][point.col] == 1) {
							liveNeighbours++;
						}
					}
				}

				if (grid[j][i] == 1) {
					if (liveNeighbours < 2) {
						newgrid[j][i] = 0;
					} else if (liveNeighbours >= 2 && liveNeighbours <= 3) {
						newgrid[j][i] = 1;
					} else if (liveNeighbours > 3) {
						newgrid[j][i] = 0;
					}
				} else {

					if (liveNeighbours == 3) {
						newgrid[j][i] = 1;
					}
				}

			}
		}

		for (int j = 0; j < newgrid.length; j++) {

			for (int i = 0; i < newgrid[j].length; i++) {

				System.out.print("" + newgrid[j][i]);
			}
			System.out.println("");
		}

		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");

	}

	static class Point {

		int row;
		int col;
		static int gridWidth;
		static int gridHeight;

		public Point(int x, int y) {
			this.row = y;
			this.col = x;
		}

		boolean isInsideGrid() {
			return row >= 0 && row < gridHeight && col >= 0 && col < gridWidth;
		}

	}

	/*
	 * public static void main(String args[]) {
	 * 
	 * Scanner in = new Scanner(System.in); int size = in.nextInt(); Point.size
	 * = size; System.err.println("Grid Size: " + size); int unitsPerPlayer =
	 * in.nextInt();
	 * 
	 * char grid[][] = new char[size][size];
	 * 
	 * // game loop while (true) { for (int i = 0; i < size; i++) { String row =
	 * in.next(); for (int j = 0; j < row.length(); j++) { grid[j][i] =
	 * row.charAt(j); } System.err.println(row); }
	 * 
	 * ArrayList<Point> playerUnits = new ArrayList<>(); for (int i = 0; i <
	 * unitsPerPlayer; i++) { int unitX = in.nextInt(); int unitY =
	 * in.nextInt(); playerUnits.add(new Point(unitX, unitY, "")); }
	 * 
	 * ArrayList<Point> enemyUnits = new ArrayList<>(); for (int i = 0; i <
	 * unitsPerPlayer; i++) { int otherX = in.nextInt(); int otherY =
	 * in.nextInt(); enemyUnits.add(new Point(otherX, otherY, "")); }
	 * 
	 * int legalActions = in.nextInt(); for (int i = 0; i < legalActions; i++) {
	 * String atype = in.next(); int index = in.nextInt(); String dir1 =
	 * in.next(); String dir2 = in.next(); }
	 * 
	 * for (int i = 0; i < playerUnits.size(); i++) {
	 * 
	 * boolean moved = false; System.err.println("------------------");
	 * System.err.println("------------------"); System.err.println(
	 * "Considering Unit: " + i + "(" + playerUnits.get(i).x + "," +
	 * playerUnits.get(i).y + ")"); ArrayList<Point> first =
	 * getMovablePointsList(playerUnits.get(i), grid, enemyUnits, playerUnits);
	 * 
	 * if (first != null) {
	 * 
	 * for (int p = 0; p < first.size(); p++) {
	 * 
	 * int unitX = first.get(p).x; int unitY = first.get(p).y; Point
	 * playerPosOld = playerUnits.get(i); playerPosOld.x = unitX; playerPosOld.y
	 * = unitY; playerUnits.set(i, playerPosOld); String firstDir =
	 * first.get(p).dir1; System.err.println("Moving to: (" + unitX + "," +
	 * unitY + ")"); ArrayList<Point> second = getBuildingPointsList(unitX,
	 * unitY, grid, enemyUnits, playerUnits); if (second != null) {
	 * System.err.println("Building at (" + second.get(0).x + "," +
	 * second.get(0).y + ")"); System.out.println("MOVE&BUILD " + i + " " +
	 * firstDir + " " + second.get(0).dir1); moved = true; break; } else {
	 * System.err.println("second == null"); }
	 * 
	 * } if (moved) { break; } } }
	 * 
	 * } }
	 * 
	 * private static ArrayList<Point> getMovablePointsList(Point myPosPoint,
	 * char grid[][], ArrayList<Point> enemyUnits, ArrayList<Point> playerUnits)
	 * {
	 * 
	 * // Point enemyPosPoint = new Point(otherX, otherY, ""); ArrayList<Point>
	 * sameLeveList = new ArrayList<>(); ArrayList<Point> oneUpLevel = new
	 * ArrayList<>(); ArrayList<Point> allLowList = new ArrayList<>();
	 * ArrayList<Point> enemyList = new ArrayList<>();
	 * 
	 * Point leftTop = new Point(myPosPoint.x - 1, myPosPoint.y - 1, "NW");
	 * Point Top = new Point(myPosPoint.x, myPosPoint.y - 1, "N"); Point
	 * rightTop = new Point(myPosPoint.x + 1, myPosPoint.y - 1, "NE"); Point
	 * left = new Point(myPosPoint.x - 1, myPosPoint.y, "W"); Point right = new
	 * Point(myPosPoint.x + 1, myPosPoint.y, "E"); Point bottomLeft = new
	 * Point(myPosPoint.x - 1, myPosPoint.y + 1, "SW"); Point bottom = new
	 * Point(myPosPoint.x, myPosPoint.y + 1, "S"); Point bottomRight = new
	 * Point(myPosPoint.x + 1, myPosPoint.y + 1, "SE");
	 * 
	 * char ch1 = grid[myPosPoint.x][myPosPoint.y]; int currentlevelValue =
	 * Integer.parseInt(ch1 + "");
	 * 
	 * System.err.println("Moment Possible at Units: ");
	 * calculateForMovement(sameLeveList, oneUpLevel, allLowList, grid, leftTop,
	 * currentlevelValue, enemyUnits, playerUnits,enemyList);
	 * calculateForMovement(sameLeveList, oneUpLevel, allLowList, grid, Top,
	 * currentlevelValue, enemyUnits, playerUnits,enemyList);
	 * calculateForMovement(sameLeveList, oneUpLevel, allLowList, grid,
	 * rightTop, currentlevelValue, enemyUnits, playerUnits,enemyList);
	 * calculateForMovement(sameLeveList, oneUpLevel, allLowList, grid, left,
	 * currentlevelValue, enemyUnits, playerUnits,enemyList);
	 * calculateForMovement(sameLeveList, oneUpLevel, allLowList, grid, right,
	 * currentlevelValue, enemyUnits, playerUnits,enemyList);
	 * calculateForMovement(sameLeveList, oneUpLevel, allLowList, grid,
	 * bottomLeft, currentlevelValue, enemyUnits, playerUnits,enemyList);
	 * calculateForMovement(sameLeveList, oneUpLevel, allLowList, grid, bottom,
	 * currentlevelValue, enemyUnits, playerUnits,enemyList);
	 * calculateForMovement(sameLeveList, oneUpLevel, allLowList, grid,
	 * bottomRight, currentlevelValue, enemyUnits, playerUnits,enemyList);
	 * 
	 * if (!oneUpLevel.isEmpty()) { return oneUpLevel; } else if
	 * (!sameLeveList.isEmpty()) { // Collections.reverse(sameLeveList); return
	 * sameLeveList; } else if (!allLowList.isEmpty()) {
	 * Collections.sort(allLowList, comparator); return allLowList; }
	 * 
	 * return null;
	 * 
	 * }
	 * 
	 * private static ArrayList<Point> getBuildingPointsList(int unitX, int
	 * unitY, char grid[][], ArrayList<Point> enemyUnits, ArrayList<Point>
	 * playerUnits) {
	 * 
	 * Point myPosPoint = new Point(unitX, unitY, "");
	 * 
	 * ArrayList<Point> sameLeveList = new ArrayList<>(); ArrayList<Point>
	 * upLevel = new ArrayList<>(); ArrayList<Point> allLowList = new
	 * ArrayList<>();
	 * 
	 * Point leftTop = new Point(unitX - 1, unitY - 1, "NW"); Point Top = new
	 * Point(unitX, unitY - 1, "N"); Point rightTop = new Point(unitX + 1, unitY
	 * - 1, "NE"); Point left = new Point(unitX - 1, unitY, "W"); Point right =
	 * new Point(unitX + 1, unitY, "E"); Point bottomLeft = new Point(unitX - 1,
	 * unitY + 1, "SW"); Point bottom = new Point(unitX, unitY + 1, "S"); Point
	 * bottomRight = new Point(unitX + 1, unitY + 1, "SE");
	 * 
	 * char ch1 = grid[myPosPoint.x][myPosPoint.y]; int currentlevelValue =
	 * Integer.parseInt(ch1 + "");
	 * System.err.println("Building Possible at Units: ");
	 * calculateForBuilding(sameLeveList, upLevel, allLowList, grid, leftTop,
	 * currentlevelValue, enemyUnits, playerUnits);
	 * calculateForBuilding(sameLeveList, upLevel, allLowList, grid, Top,
	 * currentlevelValue, enemyUnits, playerUnits);
	 * calculateForBuilding(sameLeveList, upLevel, allLowList, grid, rightTop,
	 * currentlevelValue, enemyUnits, playerUnits);
	 * calculateForBuilding(sameLeveList, upLevel, allLowList, grid, left,
	 * currentlevelValue, enemyUnits, playerUnits);
	 * calculateForBuilding(sameLeveList, upLevel, allLowList, grid, right,
	 * currentlevelValue, enemyUnits, playerUnits);
	 * calculateForBuilding(sameLeveList, upLevel, allLowList, grid, bottomLeft,
	 * currentlevelValue, enemyUnits, playerUnits);
	 * calculateForBuilding(sameLeveList, upLevel, allLowList, grid, bottom,
	 * currentlevelValue, enemyUnits, playerUnits);
	 * calculateForBuilding(sameLeveList, upLevel, allLowList, grid,
	 * bottomRight, currentlevelValue, enemyUnits, playerUnits);
	 * 
	 * if (!upLevel.isEmpty()) { return upLevel; } else if
	 * (!sameLeveList.isEmpty()) { // Collections.reverse(sameLeveList); return
	 * sameLeveList; } else if (!allLowList.isEmpty()) {
	 * Collections.sort(allLowList, comparator); return allLowList; }
	 * 
	 * return null;
	 * 
	 * }
	 * 
	 * static Comparator<Point> comparator = new Comparator<Point>() {
	 * 
	 * @Override public int compare(Point o1, Point o2) {
	 * 
	 * if (o2.level > o1.level) { return 10; } else { return -10; } } };
	 * 
	 * private static void calculateForMovement(ArrayList<Point> sameLeveList,
	 * ArrayList<Point> oneUpLevel, ArrayList<Point> allLowList, char[][] grid,
	 * Point posPoint, int currentlevelValue, ArrayList<Point> enemyUnits,
	 * ArrayList<Point> playerUnits, ArrayList<Point> enemyrUnits) {
	 * 
	 * if (posPoint.isInsideGrid() && !posPoint.isMatchFound(playerUnits)) {
	 * 
	 * char ch = grid[posPoint.x][posPoint.y]; if (ch != '.') {
	 * 
	 * int levelValue = Integer.parseInt(ch + "");
	 * posPoint.setLevel(levelValue); if (levelValue <= 3) {
	 * System.err.println("(" + posPoint.x + "," + posPoint.y + ") -->" + ch);
	 * if (posPoint.isMatchFound(enemyUnits)) { enemyrUnits.add(posPoint); }
	 * else if (currentlevelValue == levelValue) { sameLeveList.add(posPoint); }
	 * else if (currentlevelValue < levelValue && levelValue - currentlevelValue
	 * == 1) { oneUpLevel.add(posPoint); } else if (currentlevelValue >
	 * levelValue) { allLowList.add(posPoint); } } } } }
	 * 
	 * private static void calculateForBuilding(ArrayList<Point> sameLeveList,
	 * ArrayList<Point> upLevel, ArrayList<Point> allLowList, char[][] grid,
	 * Point posPoint, int currentlevelValue, ArrayList<Point> enemyUnits,
	 * ArrayList<Point> playerUnits) {
	 * 
	 * if (posPoint.isInsideGrid() && !posPoint.isMatchFound(enemyUnits) &&
	 * !posPoint.isMatchFound(playerUnits)) {
	 * 
	 * char ch = grid[posPoint.x][posPoint.y]; if (ch != '.') {
	 * 
	 * int levelValue = Integer.parseInt(ch + "");
	 * posPoint.setLevel(levelValue); if (levelValue <= 3) {
	 * System.err.println("(" + posPoint.x + "," + posPoint.y + ") -->" + ch);
	 * if (currentlevelValue == levelValue) { sameLeveList.add(posPoint); } else
	 * if (currentlevelValue < levelValue) { upLevel.add(posPoint); } else if
	 * (currentlevelValue > levelValue) { allLowList.add(posPoint); } } } } }
	 * 
	 * static class Point {
	 * 
	 * int x; int y; int level; String dir1; static int size;
	 * 
	 * Point(int x, int y, String dir1) { this.x = x; this.y = y; this.dir1 =
	 * dir1;
	 * 
	 * }
	 * 
	 * boolean isInsideGrid() { return x >= 0 && x < size && y >= 0 && y < size;
	 * }
	 * 
	 * void setLevel(int level) { this.level = level; }
	 * 
	 * boolean isSame(Point other) { return x == other.x && y == other.y; }
	 * 
	 * boolean isMatchFound(ArrayList<Point> others) { for (Point other :
	 * others) { if (other.isSame(this)) { return true; } } return false; } }
	 * 
	 */

}