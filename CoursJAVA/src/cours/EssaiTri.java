package cours;

import java.util.*;


public class EssaiTri {
	public static void main(String args[]) {
		// attention pas doublons donc il faut modifier la fonction compare de CercleC pour trier quand on a le même rayon
		NavigableSet<CercleC> arbre = new TreeSet(); 
		// on le déclare comme un navigableset car on a besoin d'un descendingIterator sinon on aurait déclaré une collection
		CercleC c1 = new CercleC(5, 3, 5.0);
		arbre.add(c1);
		CercleC c2 = new CercleC(1, 9, 3.5);
		arbre.add(c2);
		System.out.println("-- Cercles tries par rayon croissant");
		for (CercleC c : arbre) {
			c.affiche();
		}

		CercleC c3 = new CercleC(2, 9, 2.5);
		arbre.add(c3);

		System.out.println("-- Cercles tries par rayon croissant");
		for (CercleC c : arbre) {
			c.affiche();
		}

		CercleC c4 = new CercleC(0, 9, 3.5);
		arbre.add(c4);

		System.out.println("-- Cercles tries par rayon croissant");
		for (CercleC c : arbre) {
			c.affiche();
		}
		
		System.out.println("-- Cercles tries par rayon décroissant");
		for (Iterator<CercleC> it = arbre.descendingIterator(); it.hasNext() ;) {
			it.next().affiche();
		}
	}

}
