import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class CaesarCipherHelper {

	private String[] cipher;
	private char[] answer;
	private int[] key = new int[26];
	private char[] numberToChar = new char[26];
	//cipher value -> positions in cipher
	private Map<Integer, LinkedList<Integer>> cipherIndex;


	public CaesarCipherHelper(String code) {
		cipher = code.split(" ");
		answer = new char[cipher.length];
		cipherIndex = new HashMap<>(26);
		populateCipherIndex();
	}

	private void populateCipherIndex() {
		int value;
		for(int i = 0; i < cipher.length; i++) {

			try {
				value = Integer.parseInt(cipher[i]);
			}
			catch (NumberFormatException e) {
				continue;
			}
			if(value != 0) {
				if(cipherIndex.get(value) == null) {
					LinkedList<Integer> temp = new LinkedList<>();
					temp.add(i);
					cipherIndex.put(value, temp);
				}else {
					cipherIndex.get(value).add(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		// 0 is space
		String code = "";
		try {
			File myObj = new File(args[0]);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				code = myReader.nextLine();
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} 

		CaesarCipherHelper c = new CaesarCipherHelper(code);
		c.run();
	}

	private void run() {
		try (Scanner in = new Scanner(System.in)) {
			String input = "";
			char ch;
			int number;
			main: while(true) {
				System.out.println(keyToString());
				System.out.println();
				System.out.println(cipherAndAnsToString());
				System.out.println();
				System.out.print("Enter next guess (Character:Number): ");
				input = in.nextLine();
				if (input.equals("quit")) {
					break;
				}
				if (!input.equals("")) {
					String[] token = input.split(" ");
					for(int i = 0; i < token.length; i+=2) {
						ch = token[i].toUpperCase().toCharArray()[0];
						number = Integer.parseInt(token[i + 1]);
						if (checkNumberRepetition(ch, number)) {
							System.out.printf("Reset %c?(y/n): ", numberToChar[number - 1]);
							if (in.nextLine().equals("n")) {
								System.out.println();
								continue main;
							}
						}
						updateKeyAndAnswer(ch, number);
					}
				}
				System.out.println();
			}
		}
	}
	private boolean checkNumberRepetition(char c, int number) {
		return Character.isLetter(numberToChar[number - 1]);
	}

	private void updateKeyAndAnswer(char c, int number) {
		if (Character.isLetter(numberToChar[number - 1])) {//check number repetition

			key[numberToChar[number - 1] - 'A'] = 0;
		}
		key[c - 'A'] = number;
		numberToChar[number - 1] = c;
		if (cipherIndex.containsKey(number)) {//cipher does not have 1
			for(int position : cipherIndex.get(number)) {
				answer[position] = c;
			}
		}
	}

	private String cipherAndAnsToString() {
		String out = "";
		String dashes = "";
		String cipherString = "";
		int width = 0;
		for(int i = 0; i < cipher.length; i++) {
			if (cipher[i].equals("0")) {											//space box
				dashes += "\u2580 ";
				cipherString += "  ";
			} else if (!Character.isDigit(cipher[i].charAt(0))) {					//not chars
				dashes += String.format("%s ", cipher[i]);
				cipherString += "  ";
			} else if (Character.isLetter(answer[i])){								//chars
				dashes += String.format("%2c ", answer[i]);
				cipherString += String.format("%2s ", cipher[i]);
			} else {																//just dash
				dashes += "__ ";
				cipherString += String.format("%2s ", cipher[i]);
			}
			width++;
			if (width > 36) {
				out += dashes + "\n" + cipherString + "\n";
				dashes = "";
				cipherString = "";
				width = 0;
			}
		}
		out += dashes + "\n" + cipherString;
		return out;
	}


	private String keyToString() {
		String out = "";
		String k = "";
		for(int i = 0; i < 26; i++) {
			out += String.format(" %c |", 'A' + i);
			k += String.format("%2d |", key[i]);
		}

		return out + "\n" + k;
	}
}
