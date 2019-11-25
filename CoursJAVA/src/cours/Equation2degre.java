package cours;


public class Equation2degre {

	// valeur limite d'un réel assimilable a 0
	static final double EPSILON = 1E-100; // précision du calcul que l’on se
											// fixe > précision du type double
											// de JAVA
	
	/** méthode de résolution d’un polynôme du second degré Antécédent :
		Conséquent : (x- (r1+ i*i1) ) * (x- (r2+ i*i2) ) = 0
	 * @param a réel
	 * @param b réel
	 * @param c réel
	 */
	public static void polynome2ndDegre(double a, double b, double c){

		// affichage de l'équation

		System.out.println(a + " x^2 + " + b + " x " + " + " + c + " = 0");

		// vérification si c'est bien une équation du 2nd degré
		if (Math.abs(a) < EPSILON) {
			polynome1erDegre(b, c);
		} else {
			polynome2ndDegreCasGeneral(a, b, c);
		}
	}

	public static void polynome1erDegre(double a, double b) {
		// méthode de résolution d’un polynôme du premier degré
		// Antécédent : a,b réel
		// Conséquent : a * x1 + b = 0

		if (a == 0) {
			if (b == 0) {
				System.out.println("a = 0 et b = 0 : infinité de solution ");
			} else {
				System.out.println("a != 0 et b = 0 : impossible ");
			}

		} else {
			System.out.println("L'équation a pour solution : " + -b / a);
		}

	}

	public static void polynome2ndDegreCasGeneral(double a, double b, double c) {
		// méthode de résolution d’un polynôme du second degré avec a ≠ 0
		// Antécédent : a,b,c réel, a ≠ 0
		// Conséquent : (x- (r1+ i*i1) ) * (x- (r2+ i*i2) ) = 0

		// calcul du discriminant
		final double delta = (b * b) - 4 * a * c;

		if (Math.abs(delta) < EPSILON) { // cas avec une racine double
			System.out.println("L'équation du second degré a une solution réelle " + -b / (2.0 * a));
		} else {
			if (delta < 0.0) {
				calcul_et_affiche_racines_imaginaires(a, b, c, delta);
			} else {
				calcul_et_affiche_racines_réelles(a, b, c, delta);
			}
		}

	}

	public static void calcul_et_affiche_racines_réelles(double a, double b, double c, double delta) {
		// Algorithme de résolution et d’affichage des racines réelles
		// Antécédent : a,b,c réel
		// Conséquent : (x- r1 ) * (x - r2 ) = 0

		double r1, r2; // partie réelle des racines

		if (b > 0.0)
			r1 = -(b + Math.sqrt(delta)) / (2 * a);
		else
			r1 = (Math.sqrt(delta) - b) / (2 * a);
		// r1 est la racine la plus grande en valeur absolue

		r2 = (Math.abs(r1) < EPSILON) ? 0.0 : c / (a * r1);
		// Conséquent : (x- r1 ) * (x - r2 ) = 0
		System.out.println(" Deux solutions réelles : ");
		System.out.println(" x1 = " + r1);
		System.out.println(" x2 = " + r2);
	}

	public static void calcul_et_affiche_racines_imaginaires(double a, double b, double c, double delta) {
		// méthode de résolution et d’affichage des racines réelles
		// Antécédent : a,b,c réel
		// Conséquent : (x- (r1+ i*i1) ) * (x- (r2+ i*i2) ) = 0

		double r1, i1, i2; // partie réelle des racines

		r1 = -b / (2 * a);
		i1 = Math.sqrt(-delta) / (2 * a);
		i2 = -i1;
		// Conséquent : (x-(r1+ii1)) (x-(r2+ii2)) = 0
		System.out.println(" Deux solutions complexes : ");
		System.out.printf(" x1 = %.3f + %.3f i \n", r1, i1 );
		System.out.printf(" x2 = %.3f + %.3f i \n", r1, i2 );

	}

}
