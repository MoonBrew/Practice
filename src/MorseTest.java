import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

public class MorseTest  {



	private String english;
	private String morse;

	/*
	 * Example 1: Normal sentence
	 * As a rule, for every Morse sentence, we should consider a space
	 * between Morse letters, and three spaces between morse words
	 * 
	 * English: "The wizard quickly jinxed the gnomes before they vaporized."
	 * Morse: "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
     		+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
     		+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
     		+ ".-.-.-"
	 */
	@Test
	public void shouldConvertEnglishToMorse() {
		english = "The wizard quickly jinxed the gnomes before they vaporized.";
		morse = "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
				+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
				+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
				+ ".-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	@Test
	public void shouldReverseMorseToEnglish() {
		english = "The wizard quickly jinxed the gnomes before they vaporized.";
		morse = "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
				+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
				+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
				+ ".-.-.-";
		Assertions.assertEquals(morse, Morse.run(false, english));
	}

	@Test
	@Disabled
	public void shouldConvertEnglishWithTwoSpacesToMorse() {
		english = "The  wizard.";
		morse = "- .... .      .-- .. --.. .- .-. -.. "
				+ ".-.-.-";
		Assertions.assertEquals(morse, Morse.run(false, english));
	}

	@Test
	@Disabled
	public void shouldReverseToEnglishWithTwoSpacesFromMorse() {
		String english = "The  wizard.";
		String morse = "- .... .      .-- .. --.. .- .-. -.. "
				+ ".-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}
	
	
	/*
	 * Example 2 REMOVED
	 * Trailing and beginning spaces
	 * 
	 * English: " The wizard.   "
	 * Morse: "- .... .   .-- .. --.. .- .-. -.. .-.-.-"
	 */
	@Test
	@Disabled
	public void shouldIgnoreTheStartAndEndSpaces() {
		english = " The wizard.   ";
		morse = "- .... .   .-- .. --.. .- .-. -.. .-.-.-";
		Assertions.assertEquals(morse, Morse.run(false, english));
	}
}