package cours;

import java.util.Scanner;

public class Pyramide {
	/*
	 * exercice 37 série 2
	 * 
	 * @author Baptiste Geoffroy, rev. Paul PITIOT
	 * @version 1.1
	 */
	public static void main(String[] args) {

		final char charactPyramid = '*';    // character to show in pyramid
		Scanner keyboard = new Scanner(System.in); // Object handling keyboard
													// input
		int hauteur;
		do {
			System.out.println("Enter the height of your legendary '*' pyramid. Sky is the limit");
			hauteur = keyboard.nextInt();
		} while (hauteur <= 0);    // user input control

		for (int i = 0; i < hauteur; i++) {

			final int lateral_space = (hauteur - i); // Correspond to the number
												     // of spaces on each side of the stack of *

			for (int j = 0; j < lateral_space; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < 1 + (i * 2); j++) {
				System.out.print(charactPyramid);
			}

			System.out.println();

		}

		keyboard.close(); // a scanner object is a resource that need to be closed

	}

}
