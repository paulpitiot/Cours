package cours;

import java.util.logging.Level;

public class CarImp {
	public static void main(String args[]) {
		int carrés[];
		int n;
		SimpleLogger.log.log(Level.INFO,"combien de valeurs : ");
		n = Clavier.lireInt();
		carrés = new int[n]; // on crée le tableau que quand on connait sa
								// taille
//
//		for (int i = 0; i < n; i++)
//			carrés[i] = (2 * i + 1) * (2 * i + 1);

		calculValNImpair(carrés, n);

		// affichage
		for (int i = 0; i < n; i++)
			SimpleLogger.log.log(Level.INFO,(2 * i + 1) + " a pour carre " + carrés[i]);

		// for(int valCourante : carrés){
		// System.out.println(valCourante);
		// }
	}

	public static void calculValNImpair(int tab[], int n) {
		for (int i = 0; i < n; i++)
			tab[i] = (2 * i + 1) * (2 * i + 1);
	}

}
