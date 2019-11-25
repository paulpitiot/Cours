/**
 * 
 */

package cours;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * La classe Money définit pour une somme d'argent donnée,
 * indique comment la répartir selon les billets et les 
 * pièces habituelles.
 * On désire fournir le minimum de billets et de pièces.
 * @author ad.roques
 *
 */
public class Money {

	/**
	 * Programme principal
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		
		Scanner entree = new Scanner(System.in);
		
		//Ensemble des billets et des pieces possibles en euros
		final double[] billetsPieces = {500.0, 200.0, 100.0, 50.0, 20.0, 10.0,
										5.0, 2.0, 1.0, 0.5, 0.2, 0.1, 0.05,
										0.02, 0.01};
		//nombre de billets et de pieces correspondant à la somme d'argent 
		// saisie par l'utilisateur
		int[] monnaie = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		double montant, 
			   reste;
		
		int cpt = 0;   // compteur pour parcourir le tableau des billets pièces
		
		//Chaine de caracteres qui stocke la repartition des billets et des pieces
		StringBuilder monnaieTexte = new StringBuilder("");
		
		// Saisie du montant
		do {
			System.out.print("Somme d'argent souhaitée : ");
			montant = entree.nextDouble();
			if (montant <= 0.0) {
				System.out.println("Erreur de saisie. Le montant doit être "
						           + "supérieur à 0.");
			}
		} while (montant <= 0.0);
		
		// Calcul du nombre de billets et de pièces 
		// correspondant au montant saisi
		reste = montant;
		do {
			while (billetsPieces[cpt] <= reste) {
				reste -= billetsPieces[cpt];
				// Formatage du reste
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.HALF_UP);
				reste = Double.parseDouble(df.format(reste).replace(",", "."));
				monnaie[cpt]++; 
			}
			if (monnaie[cpt] > 0) { // ajout de la monnaie distrubié dans une chaine de caractere
				monnaieTexte.append(monnaie[cpt]).append(" x ").append(billetsPieces[cpt]).append(" + ");
				monnaieTexte.deleteCharAt(monnaieTexte.length()-2);
			}
			cpt++;
		} while (reste != 0 && cpt < billetsPieces.length);
		System.out.println("Monnaie finale : " + monnaieTexte);
		
		entree.close();
	}

}
