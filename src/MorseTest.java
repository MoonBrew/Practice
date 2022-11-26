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
	
	/*
	 * Example 3: A sentence with 2 spaces in between
	 * Also two spaces in English are equivalent to six spaces in Morse
	 * Assuming this space is only between words
	 * 
	 * english = "The  wizard."
	 * morse = "- .... .      .-- .. --.. .- .-. -.. .-.-.-"
	 */
	@Test
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
}