package sumCombinations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class FindQMinSumCombinationsTest {

	/*
	 * Examples
	 * Array A, Array B, Q -> Array of min sums.
	 * int [], int [], int -> int []
	 * 
	 * Input -> Expected
	 * 
	 * {3, 2},		{1, 4},			2	->	{3, 4}
	 * {4, 2, 5, 1},{8, 0, 3, 5},	3	->	{1, 2, 4}
	 * 
	 * 
	 * {4, 2, 5, 1},{8, 0, 3, 5},	0	->	{}
	 * {},			{},				0	->	{}
	 * {},			{},				10	->	{}
	 * 
	 * null,		null,			1	->	NullPointer Exception
	 * null,		{1, 4},			1	->	NullPointer Exception
	 * null,		{1, 4},			-1	->	Illegal Argument/NullPointer Exception
	 * {3, 2},		{1, 4},			-1	->	Illegal Argument Exception
	 * {3, 2},		{1, 4},			0.5	->	Compiler Error
	 * 
	 * 
	 */
	
	
	@Test
	public void shouldBeEmptyArrayIfAOrBIsEmpty() {
		Assertions.assertEquals(new int [] {},
				FindQMinSumCombinations.find(new int [] {}, new int [] {}, 1));
		
		Assertions.assertEquals(new int [] {},
				FindQMinSumCombinations.find(new int [] {}, new int [] {1, 4}, 1));
	}
	
	@Test
	public void shouldGiveNullExceptionForNullArrays() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			FindQMinSumCombinations.find(null, null, 1);
		});
		
		Assertions.assertThrows(NullPointerException.class, () -> {
			FindQMinSumCombinations.find(null, new int[]{1, 4}, 1);
		});
	}
	
	@Test
	public void shouldGiveInvalidInputExceptionForQNegativeInteger() {
		IllegalArgumentException e1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			FindQMinSumCombinations.find(null, new int[]{1, 4}, -1);
		});
		
		Assertions.assertEquals("Q should be positive.", e1.getMessage());
		
		IllegalArgumentException e2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			FindQMinSumCombinations.find(new int[]{3, 2}, new int[]{1, 4}, -1);
		});
		
		Assertions.assertEquals("Q should be positive.", e2.getMessage());
	}
	

}
