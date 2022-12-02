package Morse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

public class MorseTest  {



	private String english;
	private String morse;

	
	/**
	 * Examples: Morse to English
	 * A long sentence
	 * A short sentence with the following spaces:
	 *		1 spaces - Space is a delimiter for letters. This example is just a single word.
	 * 			Should result in no space but converting collected symbols to a letter
	 * 		2 spaces - should give error
	 * 		3 spaces - should be a single space between words
	 * 		5 spaces - should give error
	 * 		6 spaces - should be a double space between words
	 * 		7 spaces - should give error
	 * 
	 */

	/*
	 * Example: Long sentence
	 * 
	 * Morse: "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
	 		+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
	 		+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
	 		+ ".-.-.-"
	 * English: "The wizard quickly jinxed the gnomes before they vaporized."
	 */
	@Test
	public void shouldReverseLongSentenceToEnglish() {
		english = "The wizard quickly jinxed the gnomes before they vaporized.";
		morse = "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
				+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
				+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
				+ ".-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example: A word
	 * Morse = "- .... ."
	 * English = "The"
	 */
	@Test
	public void shouldReverseWordToEnglish() {
		String english = "The";
		String morse = "- .... .";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example: A Morse sentence with two spaces.
	 * Morse: "- .... .  .-- .. --.. .- .-. -.. .-.-.-";
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForSentenceWithTwoSpaces() {
		String english = "Invalid Morse Code Or Spacing";
		String morse = "- .... .  .-- .. --.. .- .-. -.. .-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}
	
	/*
	 * Example: A Morse sentence with three spaces.
	 * Morse: "- .... .  .-- .. --.. .- .-. -.. .-.-.-";
	 * English: "The wizard"
	 */
	@Test
	public void shouldReverseSentenceWithThreeSpaces() {
		String english = "The wizard.";
		String morse = "- .... .   .-- .. --.. .- .-. -.. "
				+ ".-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example: A Morse sentence with five spaces.
	 * Morse: "- .... .     .-- .. --.. .- .-. -.. .-.-.-"
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForSentenceWithFiveSpaces() {
		String english = "Invalid Morse Code Or Spacing";
		String morse = "- .... .     .-- .. --.. .- .-. -.. .-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example: A Morse sentence with six spaces.
	 * Morse: "- .... .      .-- .. --.. .- .-. -.. .-.-.-"
	 * English: "The  wizard"
	 */
	@Test
	public void shouldReverseSentenceWithSixSpaces() {
		String english = "The  wizard";
		String morse = "- .... .      .-- .. --.. .- .-. -.. .-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}
	
	/*
	 * Example: A Morse sentence with seven spaces.
	 * Morse: "- .... .      .-- .. --.. .- .-. -.. .-.-.-"
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForSentenceWithSevenSpaces() {
		String english = "Invalid Morse Code Or Spacing";
		String morse = "- .... .       .-- .. --.. .- .-. -.. .-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}
	
	/**
	 * Examples: English to Morse
	 * A long sentence
	 * A single word
	 * A short sentence with the following spaces between words:
	 *		1 spaces - The normal
	 * 		2 spaces - should give 6 spaces in Morse
	 * 		3 spaces - should give 9 spaces in Morse
	 */
	
	/*
	 * Example: Covert a long sentence
	 * English: "The wizard quickly jinxed the gnomes before they vaporized."
	 * Morse: "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
	 *			+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
	 *			+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
	 *			+ ".-.-.-"
	 */
	@Test
	public void shouldConvertLongSentenceToMorse() {
		english = "The wizard quickly jinxed the gnomes before they vaporized.";
		morse = "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
				+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
				+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
				+ ".-.-.-";
		Assertions.assertEquals(morse, Morse.run(false, english));
	}

	/*
	 * Example: A short sentence with 2 spaces in between
	 * English = "The  wizard."
	 * Morse = "- .... .      .-- .. --.. .- .-. -.. .-.-.-"
	 */
	@Test
	public void shouldConvertEnglishWithTwoSpacesToMorse() {
		english = "The  wizard.";
		morse = "- .... .      .-- .. --.. .- .-. -.. "
				+ ".-.-.-";
		Assertions.assertEquals(morse, Morse.run(false, english));
	}

	/*
	 * Example: A short sentence with 3 spaces in between
	 * English = "The   wizard."
	 * Morse = "- .... .         .-- .. --.. .- .-. -.. .-.-.-"
	 */
	@Test
	public void shouldConvertEnglishWithThreeSpacesToMorse() {
		english = "The   wizard.";
		morse = "- .... .         .-- .. --.. .- .-. -.. "
				+ ".-.-.-";
		Assertions.assertEquals(morse, Morse.run(false, english));
	}
}