package cours.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cours.Clavier;
import cours.Equation2degre;

public class Equation2degreTest {

	@Test
	public void testManuelPolynome2ndDegre() {

		double a, b, c; // coefficients de l'équation

		// lecture des coefficients

		System.out.print("a = ");
		a = Clavier.lireDouble();
		System.out.print("b = ");
		b = Clavier.lireDouble();
		System.out.print("c = ");
		c = Clavier.lireDouble();

		Equation2degre.polynome2ndDegre(a, b, c);

	}

	@Test
	public void testPolynome1erDegre() {
		Equation2degre.polynome2ndDegre(0, 0, -3);
		Equation2degre.polynome2ndDegre(0, 0, 0);
		Equation2degre.polynome1erDegre(10, 10);
	}

	@Test
	public void testPolynome2ndDegreCasGeneral() {
		Equation2degre.polynome2ndDegre(3, 4, 1);
		Equation2degre.polynome2ndDegre(3, -4, 1);
	}

	@Test
	public void testCalcul_et_affiche_racines_réelles() {
		Equation2degre.polynome2ndDegre(1, 2, 1);
		Equation2degre.polynome2ndDegre(-88, 2, 3);
	}

	@Test
	public void testCalcul_et_affiche_racines_imaginaires() {
		Equation2degre.polynome2ndDegre(5, -2, 3);
		Equation2degre.polynome2ndDegre(-2, -2, -3);
	}

}
