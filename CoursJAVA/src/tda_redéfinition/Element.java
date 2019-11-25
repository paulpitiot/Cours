package tda_redéfinition;

public class Element<V, C> {
	protected V valeur;
	protected C clé;

	public Element(V v, C c) {
		valeur = v;
		clé = c;
	}

	public C clé() {
		return clé;
	}

	public V valeur() {
		return valeur;
	}

	public void changerClé(C c) {
		clé = c;
	}

	public void changerValeur(V v) {
		valeur = v;
	}
}
