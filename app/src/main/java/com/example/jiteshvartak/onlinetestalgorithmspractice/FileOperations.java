package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Executors;

public class FileOperations {
	
	public static void main(String[] args) {
		MyFileSystem fileSystem = new MyFileSystem();
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String command = in.next();
			if (command != null) {
				if ("crt".equalsIgnoreCase(command)) {
					String fileNameToBecreated = in.next();
					String fileNameConstructed = fileSystem.createFile(fileNameToBecreated);
					System.out.println("+ " + fileNameConstructed);
				} else if ("del".equalsIgnoreCase(command)) {
					String fileNameToBeDeleted = in.next();
					String fileName = fileSystem.deleteFile(fileNameToBeDeleted);
					System.out.println("- " + fileName);
				} else if ("rnm".equalsIgnoreCase(command)) {
					String oldName = in.next();
					String newName = in.next();
					newName = fileSystem.renameFile(oldName, newName);
					System.out.println("r " + oldName + " -> " + newName);
				}
			}

		}
	}

	static class MyFileSystem {

		HashMap<String, FileNameEvaluator> hmFileNames = new HashMap<>();

		public String createFile(String fileName) {
			String fileNameConstructed;
			FileNameEvaluator evaluator = hmFileNames.get(fileName);
			if (evaluator == null) {
				evaluator = new FileNameEvaluator();
				evaluator.isReferencedObject = false;
				fileNameConstructed = fileName.trim();
			} else {
				String suffixString;
				evaluator.isReferencedObject = true;
				if (evaluator.isRootNameAvailable) {
					evaluator.isRootNameAvailable = false;
					suffixString = "";
				} else if (evaluator.availableSuffixsList.isEmpty()) {
					int suffixIndex = evaluator.startIndex++;
					suffixString = "(" + suffixIndex + ")";
				} else {
					int suffixIndex = evaluator.availableSuffixsList.get(0);
					suffixString = "(" + suffixIndex + ")";
					evaluator.availableSuffixsList.remove(0);
				}
				fileNameConstructed = fileName.trim() + suffixString.trim();
			}
			hmFileNames.put(fileNameConstructed, evaluator);
			return fileNameConstructed;
		}

		public String deleteFile(String fileName) {
			FileNameEvaluator evaluator = hmFileNames.get(fileName);
			if (evaluator != null) {
				if (fileName.contains("(")) {
					hmFileNames.remove(fileName);
					int startIndex = fileName.indexOf("(");
					int endIndex = fileName.indexOf(")");
					evaluator.availableSuffixsList.add(Integer.parseInt(fileName.substring(startIndex + 1, endIndex)));
				} else {
					evaluator.isRootNameAvailable = true;
				}
			}
			return fileName.trim();
		}

		public String renameFile(String oldName, String newName) {
			FileNameEvaluator evaluator = hmFileNames.get(oldName);
			if (evaluator != null) {
				deleteFile(oldName.trim());
				String nameTOReturn =  createFile(newName.trim());
				return nameTOReturn.trim();
			}
			return newName.trim();
		}
	}

	static class FileNameEvaluator {
		boolean isRootNameAvailable;
		boolean isReferencedObject;
		int startIndex = 1;
		ArrayList<Integer> availableSuffixsList = new ArrayList<>();
	}

}
