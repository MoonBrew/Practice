package Morse;
import java.util.HashMap;
import java.util.Map;

public class Morse {

	private static final Map<String, Character> morseToEnglishMap = populateMorseToEnglishMap();
	private static final Map<Character, String> englishToMorseMap = populateEnglishToMorseMap();

	public static String run(boolean morseToEnglish, String textToTranslate) {
		/*
		 * Write your code below; return type and arguments should be according to the problem's requirements
		 */
		String translatedText = "";

		if(morseToEnglish) {
			/*
			 * Morse to English
			 * Example with a long sentence
			 * Morse: "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
			 * 		+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
			 * 		+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
			 * 		+ ".-.-.-"
			 * English: "The wizard quickly jinxed the gnomes before they vaporized."
			 * 
			 * Example with only single space (one word)
			 * Morse = "- .... ."
			 * English = "The"
			 * 
			 * Example with 2 spaces
			 * Morse: "- .... .  .-- .. --.. .- .-. -.. .-.-.-"
			 * English: "Invalid Morse Code Or Spacing"
			 * 
			 * Example with 3 spaces
			 * Morse: "- .... .   .-- .. --.. .- .-. -.. .-.-.-"
			 * English: "The wizard."
			 * 
			 * Example with 5 spaces
			 * Morse: "- .... .     .-- .. --.. .- .-. -.. .-.-.-"
			 * English: "Invalid Morse Code Or Spacing"
			 * 
			 * Example with 6 spaces
			 * Morse = "- .... .      .-- .. --.. .- .-. -.. .-.-.-"
			 * English = "The  wizard."
			 * 
			 * Example with 7 spaces
			 * Morse: "- .... .       .-- .. --.. .- .-. -.. .-.-.-"
			 * English: "Invalid Morse Code Or Spacing"
			 * 
			 */

			String morseLetter = "";
			String spaces = "";
			boolean collectingSpaces = false;
			for(int current = 0; current < textToTranslate.length(); current++) {
				if(collectingSpaces) {
					if (textToTranslate.charAt(current) != ' '
							&& spaces.length() == 1) {
						//is delimiter space
						collectingSpaces = false;
						spaces = "";
					}
					else if (textToTranslate.charAt(current) != ' ') {
						//if 
					}
					else {//collecting spaces
						spaces += textToTranslate.charAt(current);
						if(spaces.length() == 3) {
							translatedText += morseToEnglishMap.get(morseLetter);
							spaces = "";
						}
					}
				}
				else if (textToTranslate.charAt(current) == ' ') {
					//single or triple space
					//create previous letter
					translatedText += morseToEnglishMap.get(morseLetter);
					collectingSpaces = true;
					spaces = "" + textToTranslate.charAt(current);

					return "Invalid Morse Code Or Spacing";
				}
				else {
					//collecting letters
					morseLetter += textToTranslate.charAt(current);
				}
			}
			//last letter with no space delimiter
			translatedText += morseToEnglishMap.get(morseLetter);
			translatedText = translatedText.toLowerCase();
			translatedText = Character.toUpperCase(translatedText.charAt(0)) + translatedText.substring(1);
		}
		else {
			/*
			 * English to Morse
			 * Examples:
			 * English: "The wizard quickly jinxed the gnomes before they vaporized."
			 * Morse: "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
			 * 		+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
			 * 		+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
			 * 		+ ".-.-.-"
			 * 
			 * English = "The  wizard."
			 * Morse = "- .... .      .-- .. --.. .- .-. -.. .-.-.-"
			 * 
			 * English = "The   wizard."
			 * Morse = "- .... .         .-- .. --.. .- .-. -.. .-.-.-"
			 * 			 */
			for(int current = 0; current < textToTranslate.length(); current++) {
				translatedText += englishToMorseMap.get(Character.toUpperCase(textToTranslate.charAt(current)));
				if(current + 1 != textToTranslate.length()) {//as long as there are more chars
					//logic of when to add a space: only between letters
					if(textToTranslate.charAt(current + 1) != ' ' //not at end of word
							&& textToTranslate.charAt(current) != ' ') {//map will handle spaces
						translatedText += ' ';
					}
				}
			}
		}
		return translatedText;
	}

	public static Map<String, Character> populateMorseToEnglishMap(){
		Map<String, Character> map = new HashMap<String, Character>();

		map.put(".-", 'A');
		map.put("-...", 'B');
		map.put("-.-.", 'C');
		map.put("-..", 'D');
		map.put(".", 'E');
		map.put("..-.", 'F');
		map.put("--.", 'G'); 
		map.put("....", 'H');
		map.put("..", 'I');
		map.put(".---", 'J');
		map.put("-.-", 'K');
		map.put(".-..", 'L');
		map.put("--", 'M');
		map.put("-.", 'N');
		map.put("---", 'O');
		map.put(".--.", 'P');
		map.put("--.-", 'Q');
		map.put(".-.", 'R');
		map.put("...", 'S');
		map.put("-", 'T');
		map.put("..-", 'U');
		map.put("...-", 'V');
		map.put(".--", 'W');
		map.put("-..-", 'X');
		map.put("-.--", 'Y');
		map.put("--..", 'Z');
		map.put("   ", ' ');
		map.put("--..--", ',');
		map.put("---...", ':');
		map.put("-.-.-.", ';');
		map.put(".-.-.-", '.');
		map.put(".-..-.", '"');
		map.put("-----.", '(');
		map.put(".-----", ')');
		map.put("-.--.-", '\'');
		map.put(".----", '1');
		map.put("..---", '2');
		map.put("...--", '3'); 
		map.put("....-", '4');
		map.put(".....", '5');
		map.put("-....", '6');
		map.put("--...", '7');
		map.put("---..", '8');
		map.put("----.", '9');
		map.put("-----", '0');

		return map;
	}

	public static Map<Character, String> populateEnglishToMorseMap(){
		Map<Character, String> map = new HashMap<Character, String>();

		map.put('A', ".-");
		map.put('B', "-...");
		map.put('C', "-.-.");
		map.put('D', "-..");
		map.put('E', ".");
		map.put('F', "..-.");
		map.put('G', "--."); 
		map.put('H', "....");
		map.put('I', "..");
		map.put('J', ".---");
		map.put('K', "-.-");
		map.put('L', ".-..");
		map.put('M', "--");
		map.put('N', "-.");
		map.put('O', "---");
		map.put('P', ".--.");
		map.put('Q', "--.-");
		map.put('R', ".-.");
		map.put('S', "...");
		map.put('T', "-");
		map.put('U', "..-");
		map.put('V', "...-");
		map.put('W', ".--");
		map.put('X', "-..-");
		map.put('Y', "-.--");
		map.put('Z', "--..");
		map.put(' ', "   ");
		map.put(',', "--..--");
		map.put(':', "---...");
		map.put(';', "-.-.-.");
		map.put('.', ".-.-.-");
		map.put('"', ".-..-.");
		map.put('(', "-----.");
		map.put(')', ".-----");
		map.put('\'', "-.--.-");
		map.put('1', ".----");
		map.put('2', "..---");
		map.put('3', "...--"); 
		map.put('4', "....-");
		map.put('5', ".....");
		map.put('6', "-....");
		map.put('7', "--...");
		map.put('8', "---..");
		map.put('9', "----.");
		map.put('0', "-----");

		return map;
	}
}
