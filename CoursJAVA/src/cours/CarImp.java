package cours;

import java.util.logging.Level;

public class CarImp {
	public static void main(String args[]) {
		int carr�s[];
		int n;
		SimpleLogger.log.log(Level.INFO,"combien de valeurs : ");
		n = Clavier.lireInt();
		carr�s = new int[n]; // on cr�e le tableau que quand on connait sa
								// taille
//
//		for (int i = 0; i < n; i++)
//			carr�s[i] = (2 * i + 1) * (2 * i + 1);

		calculValNImpair(carr�s, n);

		// affichage
		for (int i = 0; i < n; i++)
			SimpleLogger.log.log(Level.INFO,(2 * i + 1) + " a pour carre " + carr�s[i]);

		// for(int valCourante : carr�s){
		// System.out.println(valCourante);
		// }
	}

	public static void calculValNImpair(int tab[], int n) {
		for (int i = 0; i < n; i++)
			tab[i] = (2 * i + 1) * (2 * i + 1);
	}

}
