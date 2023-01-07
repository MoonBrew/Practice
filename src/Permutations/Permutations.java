package Permutations;

import java.util.Set;
import java.util.TreeSet;

/**
 * Find all the permutations of a String
 * @author MoonBrew
 *
 */
public class Permutations {
	
	public static Set<String> get(String word) {
		Set<String> result = new TreeSet<String>();
		if(word == "") {
		}
		else if (word.length() == 1) {
			result.add(word);
		}
		else {
			//result.add(word);
			//result.add("" + word.charAt(1) + word.charAt(0));
			/*
			 * 3 letter word
			 * Input: "abc"
			 * Output: ["abc", "acb", "bac", "bca", "cab", "cba"]
			 */
			for(int i = 0; i < word.length(); i++) {
				String subWord = word.substring(0, i) + word.substring(i + 1);
				for(String subPermutation : get(subWord)) {
					result.add(word.charAt(i) + subPermutation);
				}
			}
		}
		return result;
	}
}
