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

			String collectedSymbols = "";
			String collectedSpaces = "";
			boolean firstLetter = true;
			for(char c : textToTranslate.toCharArray()) {
				//encounter non-space
				//process collected spaces
				//stop collecting spaces
				//start collecting letters
				if(c != ' ') {
					
					//process collected spaces
					//collectedSpaces = 
					//""	in between symbols, do nothing
					//" "	in between letters, do nothing
					//"  "(2)(2%3=2)	Wrong number of spaces, give error
					//"   "(3)(3%3=0) convert to single space " "(1)(3/3=1)
					//"     "(5)(5%3=2) Wrong number of spaces, give error
					//"      "(6)(6%3=0) convert to double space "  "(2)(6/3=2)
					//"       "(7)(7%3=1) Wrong number of spaces, give error
					if(collectedSpaces.length() > 1) {
						if(collectedSpaces.length() % 3 != 0) {
							return "Invalid Morse Code Or Spacing";
						}
						else {
							for(int count = 0; count < collectedSpaces.length() / 3; count++) {
								translatedText += ' ';
							}
						}
					}
					
					//stop collecting spaces
					collectedSpaces = "";
					
					//start collecting letters
					collectedSymbols += c;
				}
				//encounter space
				//process collected symbols
				//stop collecting symbols 
				//start collecting spaces
				else if(c == ' ') {
					//process collected symbols
					//collectedSymbols = 
					//""	in between spaces, do nothing
					//"*"	get letter from collected symbols
					if(collectedSymbols.length() > 0){
						char convertedLetter;
						//Capitalise first letter
						if (firstLetter) {
							convertedLetter = morseToEnglishMap.get(collectedSymbols);
							firstLetter = false;
						}
						else {
							convertedLetter = Character.toLowerCase(morseToEnglishMap.get(collectedSymbols));
						}
						translatedText += convertedLetter;
						
						//stop collecting symbols 
						collectedSymbols = "";
					}
					
					//start collecting spaces
					collectedSpaces += c;
				}
			}
			
			//last letter has no delimiter
			char convertedLetter = Character.toLowerCase(morseToEnglishMap.get(collectedSymbols));
			translatedText += convertedLetter;

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

	public static Map<String, Character> populateMorseToEnglishMap() {
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

	public static Map<Character, String> populateEnglishToMorseMap() {
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
