package Permutations;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PemutationsTest {
	
	private Set<String> expected = new TreeSet<String>();

	/*
	 * Empty string
	 * Input: ""
	 * Output: []
	 */
	@Test
	public void shouldDoNothingForEmpty() {
		expected.clear();
		Assertions.assertEquals(expected, Permutations.get(""));
	}

	/*
	 * 1 letter word
	 * Input: "a"
	 * Output: ["a"]
	 */
	@Test
	public void shouldDoNothingForSingle() {
		expected.clear();
		expected.add("a");
		Assertions.assertEquals(expected, Permutations.get("a"));
	}

	/*
	 * 2 letter word
	 * Input: "ab"
	 * Output: ["ab", "ba"]
	 */
	@Test
	public void givenTwoLetterWordThenTwoResults() {
		expected.clear();
		Collections.addAll(expected, new String [] {"ab", "ba"});
		Assertions.assertEquals(expected, Permutations.get("ab"));
	}

	/*
	 * 3 letter word
	 * Input: "abc"
	 * Output: ["abc", "acb", "bac", "bca", "cab", "cba"]
	 */
	@Test
	public void givenThreeLetterWordThenSixResults() {
		expected.clear();
		Collections.addAll(expected, new String[] {"abc", "acb", "bac",
				"bca", "cab", "cba"});
		Assertions.assertEquals(expected, Permutations.get("abc"));
	}

	/*
	 * 4 letter word
	 * Input: "abcd"
	 * Output:["abcd", "abdc", "acbd", "acdb", "adbc", "adcb"]
	 * 		+ ["bacd", "badc", "bcad", "bcda", "bdac", "bdca"]
	 * 		+ ["cabd", "cadb", "cbad", "cbda", "cdab", "cdba"]
	 * 		+ ["dabc", "dacb", "dbac", "dbca", "dcab", "dcba"]
	 * 
	 */
	@Test
	public void givenFourLetterWordThen24Results() {
		expected.clear();
		Collections.addAll(expected, new String[]
				{"abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
				"bacd", "badc", "bcad", "bcda", "bdac", "bdca",
				"cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
				"dabc", "dacb", "dbac", "dbca", "dcab", "dcba"});
		Assertions.assertEquals(expected, Permutations.get("abcd"));
	}
	
	/*
	 * 4 letter word different order
	 * Input: "cadb"
	 * Output:["abcd", "abdc", "acbd", "acdb", "adbc", "adcb"]
	 * 		+ ["bacd", "badc", "bcad", "bcda", "bdac", "bdca"]
	 * 		+ ["cabd", "cadb", "cbad", "cbda", "cdab", "cdba"]
	 * 		+ ["dabc", "dacb", "dbac", "dbca", "dcab", "dcba"]
	 * 
	 */
	@Test
	public void givenFourLetterWordInDifferentOrderThen24Results() {
		expected.clear();
		Collections.addAll(expected, new String[]
				{"abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
				"bacd", "badc", "bcad", "bcda", "bdac", "bdca",
				"cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
				"dabc", "dacb", "dbac", "dbca", "dcab", "dcba"});
		Assertions.assertEquals(expected, Permutations.get("cadb"));
	}
	
	/*
	 * 4 letter word with duplicate letters
	 * Input: "aabd"
	 * Output with repetitions:
	 * 			{"aabd", "aadb", "abad", "abda", "adab", "adba",
				"aabd", "aadb", "abad", "abda", "adab", "adba",
				"baad", "bada", "baad", "bada", "bdaa", "bdaa",
				"daab", "daba", "daab", "daba", "dbaa", "dbaa"}
	 * Output: {"aabd", "aadb", "abad", "abda", "adab", "adba",
				"baad", "bada",                 "bdaa",       
				"daab", "daba",                 "dbaa"        }
	 */
	@Test
	public void givenFourLetterWordWithRepetitionThen12Results() {
		expected.clear();
		Collections.addAll(expected, new String[]
				{"aabd", "aadb", "abad", "abda", "adab", "adba",
				"baad", "bada",                 "bdaa",       
				"daab", "daba",                 "dbaa"        });
		Assertions.assertEquals(expected, Permutations.get("aabd"));
	}
}
