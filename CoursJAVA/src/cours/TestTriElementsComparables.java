package cours;

import java.util.ArrayList;
import java.util.Collections;

public class TestTriElementsComparables {

	public static void main(String args[]) {
		ArrayList<CercleC> liste = new ArrayList<CercleC>();
		CercleC c1 = new CercleC(5, 3, 5.0);
		CercleC c2 = new CercleC(1, 9, 3.5);
		CercleC c3 = new CercleC(2, 9, 2.5);
		liste.add(c1);
		liste.add(c2);
		liste.add(c3);
		// tri suivant le rayon du cercle


		Collections.sort(liste);
		System.out.println("-- Cercles tries par rayon croissant");
		for (CercleC c : liste)
			c.affiche();
	}
}





