package Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Find the next permutation. Return -1 if none.
 * @author MoonBrew
 */
public class FindNextPermutation {
	
	public static String find(String aPermutation) {
		return findShortcut(aPermutation);
	}

	/*
	 * String -> String
	 * Brute Force
	 */
	public static String findBruteForce(String aPermutation) {

		List<String> permutationsList = new ArrayList<String>();
		permutationsList.addAll(Permutations.get(aPermutation));
		//should be sorted as set was a TreeSet
		int index = permutationsList.indexOf(aPermutation);
		if (index == permutationsList.size() - 1) {
			return "-1";
		}
		else {
			return permutationsList.get(index + 1);
		}
	}
	
	public static String findShortcut(String aPermutation) {
		/*
		 * Examples
		 * 
		 * Input -> Expected
		 * 	""	->	"-1"
		 * "cba" -> "-1"
		 * "cab" -> "cba"
		 * "badc"	->	"bcad"
		 * "abcd"	->	"abdc"
		 * 
		 * With repetition
		 * "baad"	-> "bada"
		 * "dbaa	-> "-1"
		 */
		if (aPermutation.isEmpty()) {
			return "-1";
		}
		List<Character> lettersList = new ArrayList<Character>();
		for(char l : aPermutation.toCharArray()) {
			lettersList.add(l);
		}
		Collections.sort(lettersList);
		
		char fistLetter = aPermutation.charAt(0);
		String subWord = aPermutation.substring(1);
		
		//get next subWord permutation
		List<String> subWordPermutations = new ArrayList<String>();
		subWordPermutations.addAll(Permutations.get(subWord));
		int subWordIndex = subWordPermutations.indexOf(subWord);
		if (subWordIndex != subWordPermutations.size() - 1) {
			return fistLetter + subWordPermutations.get(subWordIndex + 1);
		}
		else {// get next letter
			int letterIndex = lettersList.indexOf(fistLetter);
			if (letterIndex != lettersList.size() - 1) {
				fistLetter = lettersList.get(letterIndex + 1);
				//new subWord
				int firstLetterIndex = aPermutation.indexOf(fistLetter);
				subWord = aPermutation.substring(0, firstLetterIndex) + 
						aPermutation.substring(firstLetterIndex + 1);
				subWordPermutations.clear();
				subWordPermutations.addAll(Permutations.get(subWord));
				return fistLetter + subWordPermutations.get(0);
			}
		}
		return "-1";
	}
}
