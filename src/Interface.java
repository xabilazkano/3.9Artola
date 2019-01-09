import java.util.ArrayList;
import java.util.Scanner;

import com.zubiri.hangman.*;

public class Interface {

	public static void main(String[] args) {
		Word hang = new Word("kaixo");
		Scanner sc = new Scanner(System.in);
		// Print the games' description
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess random word.");
		System.out.println(
				"For this, you will be able to enter 5 letters that may appear in the word, or not. After this, you will only have a chance to guess the word and win the game.");

		boolean playAgain = true;
		while (playAgain == true) {
			int flag = 0;

			while (flag < 5) {

				System.out.println();
				System.out.println("Enter a letter");

				// Create a string object with the letter's value

				String possibleLetter = sc.next().toLowerCase();
				char[] letterArray = possibleLetter.toCharArray();
				if (letterArray.length == 1) {
					if (Character.isLetter(letterArray[0])) {

						// Check that the player has entered just a character

						if (hang.letterMatch(possibleLetter)) {

							ArrayList<Integer> positions = hang.matchPositions(possibleLetter);
							System.out.println("The letter is in the positions");
							for (int i = 0; i < positions.size(); i++) {
								System.out.print(" " + (positions.get(i)+1));

							}
						} else {
							System.out.println("The letter isn't in the word");
						}
						flag++;

						System.out.println();
					}
				}
				// If the player entered more than one characters, ask him/her to enter just one
				else {
					System.out.println("Don't cheat, please enter a letter.");
				}

			}
			System.out.println("Five letters tried, now is time to guess the surname");
			System.out.println("Enter a word");
			sc.nextLine();
			String playerWord = sc.nextLine().toLowerCase();
			String[] playerWordArray = playerWord.split(" ");
			if (playerWordArray.length == 1) {
				if (playerWord.equals(hang.getWord())) {
					System.out.println("Congratulations the word was " + hang.getWord());
				} else {
					System.out.println("Sorry, you loose. The word was " + hang.getWord());
				}
			} else {
				System.out.println("Enter just one word");
			}

			System.out.println("Do you want to play again? ");
			boolean incorrectResponse = true;
			while (incorrectResponse) {
				String choose = sc.next();
				if (choose.equals("yes")) {

					incorrectResponse = false;
				} else if (choose.equals("no")) {
					System.out.println("Bye!");
					playAgain = false;
					incorrectResponse = false;
				} else {
					System.out.println("Enter a valid option (yes/no)");
				}
			}
		}
	}

}
