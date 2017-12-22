package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class MagazineTest {
	Map<String, Integer> magazineMap = new HashMap<>();
	Map<String, Integer> noteMap = new HashMap<>();

	public MagazineTest(String magazine, String note) {

		String magazineStrings[] = magazine.split(" ");
		String noteStrings[] = note.split(" ");

		constructMap(magazineStrings,magazineMap);
		constructMap(noteStrings,noteMap);
		
		System.out.println("");
	

	}

	private void constructMap(String[] magazineStrings , Map<String, Integer> magazineMap ) {
		for (String str : magazineStrings) {
			Integer strCountFromMap = magazineMap.get(str);
			if(strCountFromMap==null){
				magazineMap.put(str, 1);
			}else{
				magazineMap.put(str, strCountFromMap.intValue() + 1);
			}
		}
	}

	public boolean solve() {

		Set<String> keys = noteMap.keySet();
		for(String noteMapKey:keys){
			Integer occuranceINMagazine = magazineMap.get(noteMapKey);
			Integer occuranceINNote = noteMap.get(noteMapKey);
			if(occuranceINMagazine ==null ||occuranceINMagazine.intValue()<occuranceINNote.intValue()){
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MagazineTest s = new MagazineTest(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		boolean answer = s.solve();
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
