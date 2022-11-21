import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

public class MorseTest  {



	private String english;
	private String morse;

	/*
	 * Example 1
	 * 
	 * English: "The wizard quickly jinxed the gnomes before they vaporized."
	 * Morse: "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
     		+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
     		+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
     		+ ".-.-.-"
	 */
	@Test
	public void shouldConvertFirstExampleToMorseTest() {
		english = "The wizard quickly jinxed the gnomes before they vaporized.";
		morse = "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
				+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
				+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
				+ ".-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}

	@Test
	public void shouldReverseFromMorseToFirstExampleTest() {
		english = "The wizard quickly jinxed the gnomes before they vaporized.";
		morse = "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
				+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
				+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
				+ ".-.-.-";
		Assertions.assertEquals(morse, Morse.run(false, english));
	}

	@Test
	@Disabled
	public void shouldConvertEnglishWithTwoSpacesToMorseTest() {
		//should add 3 spaces in morse for each space in english
		english = "The  wizard.";
		morse = "- .... .      .-- .. --.. .- .-. -.. "
				+ ".-.-.-";
		Assertions.assertEquals(morse, Morse.run(false, english));
	}

	@Test
	@Disabled
	public void shouldReverseToEnglishWithTwoSpacesFromMorseTest() {
		String english = "The  wizard.";
		String morse = "- .... .      .-- .. --.. .- .-. -.. "
				+ ".-.-.-";
		Assertions.assertEquals(english, Morse.run(true, morse));
	}
}