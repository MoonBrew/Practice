package Permutations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindNextPermutationTest {

	/*
	 * Examples
	 * 
	 * Input -> Expected
	 * 	""	->	"-1"
	 * "cba" -> "-1"
	 * "cab" -> "cba"
	 * "badc"	->	"bcad"
	 * "abcd"	->	"abdc"
	 * "bdca"	->	"cabd"
	 * 
	 * With repetition
	 * "baad"	-> "bada"
	 * "dbaa	-> "-1"
	 */

	@Test
	public void shouldDoNothingForEmpty() {
		Assertions.assertEquals("-1", FindNextPermutation.find(""));
	}
	
	@Test
	public void shouldDoNothingForLastPermutationOf3Letters() {
		Assertions.assertEquals("-1", FindNextPermutation.find("cba"));
	}
	
	@Test
	public void shouldFindNextPermutationOf3Letters() {
		Assertions.assertEquals("cba", FindNextPermutation.find("cab"));
	}
	
	@Test
	public void shouldFindNextPermutationOf4Letters1() {
		Assertions.assertEquals("bcad", FindNextPermutation.find("badc"));
	}
	
	@Test
	public void shouldFindNextPermutationOf4Letters2() {
		Assertions.assertEquals("abdc", FindNextPermutation.find("abcd"));
	}
	
	@Test
	public void shouldFindNextPermutationOf4Letters3() {
		Assertions.assertEquals("cabd", FindNextPermutation.find("bdca"));
	}
	
	@Test
	public void shouldFindNextPermutationOf4LettersWithRepetition1() {
		Assertions.assertEquals("bdaa", FindNextPermutation.find("bada"));
	}
	
	@Test
	public void shouldFindNextPermutationOf4LettersWithRepetition2() {
		Assertions.assertEquals("daab", FindNextPermutation.find("bdaa"));
	}
	
	@Test
	public void shouldDoNothingForLastPermutationOf4LettersWithRepetition() {
		Assertions.assertEquals("-1", FindNextPermutation.find("dbaa"));
	}
}
