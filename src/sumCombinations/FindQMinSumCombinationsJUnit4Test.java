package sumCombinations;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class FindQMinSumCombinationsJUnit4Test {

	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void shouldGiveInvalidInputExceptionForQNegativeInteger1() {
		expected.expect(IllegalArgumentException.class);
		expected.expectMessage("Q should be positive.");
		
		FindQMinSumCombinations.find(null, new int[]{1, 4}, -1);
	}
	
	@Test
	public void shouldGiveInvalidInputExceptionForQNegativeInteger2() {
		expected.expect(IllegalArgumentException.class);
		expected.expectMessage("Q should be positive.");
		
		FindQMinSumCombinations.find(new int[]{3, 2}, new int[]{1, 4}, -1);
	}
}
