package leetCode1;

import java.util.*;

public class findWords {
	public String[] Solution(String[] words) {
		// check input strings:
		if (words.length == 0) {
			return new String[0];
		}

		// create and initialize keyboard rows in HashMap:
		char[] row1 = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		char[] row2 = { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' };
		char[] row3 = { 'z', 'x', 'c', 'v', 'b', 'n', 'm' };

		List<Character> row1List = new ArrayList<>();
		List<Character> row2List = new ArrayList<>();
		List<Character> row3List = new ArrayList<>();

		for (char letter : row1) {
			row1List.add(letter);
		}
		for (char letter : row2) {
			row2List.add(letter);
		}
		for (char letter : row3) {
			row3List.add(letter);
		}

		// check and add the words needed to result:
		List<String> tempResult = new ArrayList<>();
		for (String word : words) {
			char[] letters = word.toLowerCase().toCharArray();
			if (letters.length == 0) {
				continue;
			}

			if (row1List.contains(letters[0])) {
				if (isUseOneRow(letters, row1List)) {
					tempResult.add(word);
				} else {
					continue;
				}
			} else if (row2List.contains(letters[0])) {
				if (isUseOneRow(letters, row2List)) {
					tempResult.add(word);
				} else {
					continue;
				}
			} else {
				if (isUseOneRow(letters, row3List)) {
					tempResult.add(word);
				} else {
					continue;
				}
			}
		}

		// convert result to string[]:
		String[] result = new String[tempResult.size()];
		for (int i = 0; i < tempResult.size(); i++) {
			result[i] = tempResult.get(i);
		}
		return result;
	}

	// check up whether the word use just one row on keyboard:
	private boolean isUseOneRow(char[] letters, List<Character> row) {
		for (char letter : letters) {
			if (!row.contains(letter)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		findWords aa = new findWords();
		String[] test = {};
		String[] result = aa.Solution(test);
		for (String word : result) {
			System.out.print(word + " ");
		}
	}
}
