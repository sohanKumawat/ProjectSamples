package com.demo.slk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCount {

	private static Map<String, Map<String, Integer>> fileMapPath = new HashMap<>();

	public static Map<String, Integer> wordCount(File file) {
		Map<String, Integer> wordCountMap = new HashMap<>();
		try {
			Files.lines(file.toPath()).map(line -> line.trim()).filter(line -> !line.isEmpty() && line.length() > 0)
					.forEach(line -> {
						StringTokenizer stringToken = new StringTokenizer(line, " ");
						System.out.println("Lines --" + line + " -- Count -- " + stringToken.countTokens());
						while (stringToken.hasMoreTokens()) {
							String token = stringToken.nextToken();
							wordCountMap.put(token,
									wordCountMap.containsKey(token) ? (wordCountMap.get(token) + 1) : 1);
							fileMapPath.put("/Users/msg/Desktop/notes.txt", wordCountMap);
						}
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordCountMap;
	}

	public static Map<String, Integer> getWordsCount(File file) {
		String fPath = file.getAbsolutePath().intern();
		Map<String, Integer> wordCount = null;
		synchronized (fPath) {
			if (fileMapPath.containsKey(fPath))
				return fileMapPath.get(fPath);
			else {
				wordCount = wordCount(file);
				fileMapPath.put(fPath, wordCount);
				return wordCount;
			}
		}
	}

	public static void fileReader(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] token = line.split("\\s");
				System.out.println("Strng tokens " + token);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String fPath1 = new String("info1");
		String fPath2 = new String("info1");
		/*
		 * fPath1=fPath1.intern(); fPath2=fPath2.intern();
		 */
		// File file1=new File(fPath1);
		// File file2=new File(fPath2);
		/*
		 * System.out.println(fPath1.equals(fPath2));
		 * System.out.println(fPath1==fPath2);
		 */
		//WordCount.fileReader("/Users/msg/Desktop/notes.txt");
		Map<String, Integer> wcMap = WordCount.getWordsCount(new File("/Users/msg/Desktop/notes.txt"));
		System.out.println("** map ** " + wcMap.size());
	}

}
