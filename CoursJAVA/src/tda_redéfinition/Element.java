package tda_red�finition;

public class Element<V, C> {
	protected V valeur;
	protected C cl�;

	public Element(V v, C c) {
		valeur = v;
		cl� = c;
	}

	public C cl�() {
		return cl�;
	}

	public V valeur() {
		return valeur;
	}

	public void changerCl�(C c) {
		cl� = c;
	}

	public void changerValeur(V v) {
		valeur = v;
	}
}
