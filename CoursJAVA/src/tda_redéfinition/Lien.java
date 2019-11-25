package tda_redéfinition;

public class Lien<T> {
	protected Lien<T> suivant;

	protected Lien<T> suivant() {
		return suivant;
	}

	protected void suivant(Lien<T> s) {
		suivant = s;
	}

}
