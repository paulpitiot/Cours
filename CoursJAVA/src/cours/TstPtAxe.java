package cours;

class PointAxe {
	public PointAxe(char c, double x) // constructeur
	{
		nom = c;
		abs = x;
	}

	public void affiche() {
		System.out.println("Point de nom " + nom + "  d'abscisse " + abs);
	}

	public void translate(double dx) {
		abs += dx;
	}

	private char nom; // nom du point
	private double abs; // abscisse du point

	public double getAbs() {
		return abs;
	}
}

public class TstPtAxe {
	public static void main(String args[]) {

		PointAxe p1 = new PointAxe('A', 2.5);
		p1.affiche();

		p1.translate(7.5);
		p1.affiche();

		PointAxe p2 = new PointAxe('B', 5.1);
		p2.affiche();

		p1 = p2;
		p1.affiche();

		p2.translate(5.2);

	}
}
