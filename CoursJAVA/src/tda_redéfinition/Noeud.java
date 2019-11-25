package tda_redéfinition;

public class Noeud<E> extends Lien<E> {
	protected E valeur;

	public Noeud(E e) {
		valeur = e;
	}

	public Noeud(E e, Noeud<E> s) {
		valeur = e;
		suivant(s);
	}

	public E valeur() {
		return valeur;
	}

	public void changerValeur(E e) {
		valeur = e;
	}

	public Noeud<E> noeudSuivant() {
		return (Noeud<E>) suivant();
	}

	public void noeudSuivant(Noeud<E> s) {
		suivant(s);
	}

	public String toString() {
		return valeur.toString();
	}
}
