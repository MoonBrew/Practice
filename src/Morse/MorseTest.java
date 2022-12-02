package Morse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorseTest  {



	private String english;
	private String morse;


	/**
	 * Examples: Morse to English
	 * A long sentence
	 * A short sentence with the following spaces in-between:
	 *		1 spaces - Space is a delimiter for letters. This example is just a single word.
	 * 			Should result in no space but converting collected symbols to a letter
	 * 		2 spaces - should give error
	 * 		3 spaces - should be a single space between words
	 * 		5 spaces - should give error
	 * 		6 spaces - should be a double space between words
	 * 		7 spaces - should give error
	 * 
	 * No symbol examples:
	 * 		An empty string
	 * 		A single space
	 * 		A double space
	 * 		A triple space - should give a single space
	 * 		A four space
	 * 		A five space
	 * 		A six space - should give a double space
	 * 		A seven space
	 * 		Rest should give error.
	 */

	/*
	 * Example: Long sentence
	 * 
	 * Morse: "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
	 		+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
	 		+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
	 		+ ".-.-.-"
	 * English: "the wizard quickly jinxed the gnomes before they vaporized."
	 */
	@Test
	public void shouldReverseLongSentenceToEnglish() {
		english = "the wizard quickly jinxed the gnomes before they vaporized.";
		morse = "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
				+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
				+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
				+ ".-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example: A word
	 * Morse = "- .... ."
	 * English = "the"
	 */
	@Test
	public void shouldReverseWordToEnglish() {
		english = "the";
		morse = "- .... .";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example: A Morse sentence with two spaces.
	 * Morse: "- .... .  .-- .. --.. .- .-. -.. .-.-.-";
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForSentenceWithTwoSpaces() {
		english = "Invalid Morse Code Or Spacing";
		morse = "- .... .  .-- .. --.. .- .-. -.. .-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example: A Morse sentence with three spaces.
	 * Morse: "- .... .  .-- .. --.. .- .-. -.. .-.-.-";
	 * English: "the wizard"
	 */
	@Test
	public void shouldReverseSentenceWithThreeSpaces() {
		english = "the wizard.";
		morse = "- .... .   .-- .. --.. .- .-. -.. "
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
		english = "Invalid Morse Code Or Spacing";
		morse = "- .... .     .-- .. --.. .- .-. -.. .-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example: A Morse sentence with six spaces.
	 * Morse: "- .... .      .-- .. --.. .- .-. -.. .-.-.-"
	 * English: "the  wizard"
	 */
	@Test
	public void shouldReverseSentenceWithSixSpaces() {
		english = "the  wizard.";
		morse = "- .... .      .-- .. --.. .- .-. -.. .-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example: A Morse sentence with seven spaces.
	 * Morse: "- .... .      .-- .. --.. .- .-. -.. .-.-.-"
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForSentenceWithSevenSpaces() {
		english = "Invalid Morse Code Or Spacing";
		morse = "- .... .       .-- .. --.. .- .-. -.. .-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example an empty Morse sentence.
	 * 
	 * Morse: ""
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForEmptySentence() {
		english = "Invalid Morse Code Or Spacing";
		morse = "";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example an Morse sentence with just a single space. No symbols
	 * 
	 * Morse: " "
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForSentenceWithSingleSpaceNoSymbols() {
		english = "Invalid Morse Code Or Spacing";
		morse = " ";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example an Morse sentence with just a two spaces. No symbols
	 * 
	 * Morse: "  "
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForSentenceWithTwoSpacesNoSymbols() {
		english = "Invalid Morse Code Or Spacing";
		morse = "  ";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example an Morse sentence with just a three spaces. No symbols
	 * 
	 * Morse: "   "
	 * English: " "
	 */
	@Test
	public void shouldReverseSentenceWithThreeSpacesNoSymbols() {
		english = " ";
		morse = "   ";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example an Morse sentence with just a four spaces. No symbols
	 * 
	 * Morse: "    "
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForSentenceWithFourSpacesNoSymbols() {
		english = "Invalid Morse Code Or Spacing";
		morse = "    ";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example an Morse sentence with just a five spaces. No symbols
	 * 
	 * Morse: "     "
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForSentenceWithFiveSpacesNoSymbols() {
		english = "Invalid Morse Code Or Spacing";
		morse = "     ";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example an Morse sentence with just a six spaces. No symbols
	 * 
	 * Morse: "      "
	 * English: "  "
	 */
	@Test
	public void shouldReverseSentenceWithSixSpacesNoSymbols() {
		english = "  ";
		morse = "      ";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	/*
	 * Example an Morse sentence with just a seven spaces. No symbols
	 * 
	 * Morse: "       "
	 * English: "Invalid Morse Code Or Spacing"
	 */
	@Test
	public void shouldGiveErrorForSentenceWithSevenSpacesNoSymbols() {
		english = "Invalid Morse Code Or Spacing";
		morse = "       ";
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
	 * An empty string should return an empty string.
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

	/*
	 * Example: An empty string
	 * English = ""
	 * Morse = ""
	 */
	@Test
	public void shouldConvertEmptyStringToEmptyString() {
		english = "";
		morse = "";
		Assertions.assertEquals(morse, Morse.run(false, english));
	}
}