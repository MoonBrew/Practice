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
			for(String word : textToTranslate.split("   ")) {
				for(String morseLetter : word.split(" ")) {
					translatedText += morseToEnglishMap.get(morseLetter);
				}
				translatedText += " ";
			}
			translatedText = translatedText.toLowerCase();
			translatedText = Character.toUpperCase(translatedText.charAt(0)) + translatedText.substring(1);
			translatedText = translatedText.trim();
		}
		else {
			/*
			English to Morse
			English: "The wizard quickly jinxed the gnomes before they vaporized."
			Morse: "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.."
		     		+ " -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -..."
		     		+ " . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. "
		     		+ ".-.-.-"
		     */
			for(int current = 0; current < textToTranslate.length(); current++) {
				translatedText += englishToMorseMap.get(Character.toUpperCase(textToTranslate.charAt(current)));
				int next = current + 1;
				if(next != textToTranslate.length()) {//translation is not done
					if(textToTranslate.charAt(next) != ' ' //next char is not a space
							&& textToTranslate.charAt(current) != ' ') {//current char is not a space
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
		map.put("-.-.-.-", ' ');
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
