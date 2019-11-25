
package cours;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EssaiComparateur {
	public static void main(String args[]) {
		ArrayList<Cercle> liste = new ArrayList<Cercle>();
		Cercle c1 = new Cercle(5, 3, 5.0);
		Cercle c2 = new Cercle(1, 9, 3.5);
		Cercle c3 = new Cercle(2, 9, 2.5);
		liste.add(c1);
		liste.add(c2);
		liste.add(c3);
		// tri suivant le rayon du cercle

		
		
		ComparateurRayon Compare_rayon = new ComparateurRayon();

		Collections.sort(liste, Compare_rayon);
		System.out.println("-- Cercles tries par rayon croissant");
		for (Cercle c : liste)
			c.affiche();
		
		
		
		// tri suivant l'abcisse du cercle
		Collections.sort(liste, new Comparator<Cercle>() {
			public int compare(Cercle c1, Cercle c2) {
				double x1 = c1.getX();
				double x2 = c2.getX();
				if (x1 < x2)
					return -1;
				else if (x1 == x2)
					return 0;
				else
					return 1;
			}
		});
		System.out.println("-- Cercles tries par abscisse croissante");
		for (Cercle c : liste)
			c.affiche();
	}
}

class ComparateurRayon implements Comparator<Cercle> {
	public int compare(Cercle c1, Cercle c2) {
		double r1 = c1.getRayon();
		double r2 = c2.getRayon();
		if (r1 < r2)
			return -1;
		else if (r1 == r2)
			return 0;
		else
			return 1;
	}
}

class Cercle {
	public Cercle(int x, int y, double rayon) {
		this.x = x;
		this.y = y;
		this.rayon = rayon;
	}

	public void affiche() {
		System.out.println("Coordonnees : " + x + ", " + y + " ; rayon : " + rayon);
	}

	public double getRayon() {
		return rayon;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	private int x, y;
	double rayon;
}