package tda_redéfinition;

import java.util.Iterator;
import java.util.NoSuchElementException;

import tda_redéfinition.exceptions.RangInvalideException;

public class ListeChainee<E> extends ListeAbstraite<E> implements Liste<E> {
	protected int lg;
	protected Noeud<E> tete;
	public int longueur() {
		return lg;
	}
	public E ième(int r) throws RangInvalideException { // complexité en O(n)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		Noeud<E> n = tete;
		for (int i = 1; i < r; i++) {
			n = n.noeudSuivant();
		}
		// n désigne le noeud de rang r
		return n.valeur();
	}
	public void supprimer(int r) throws RangInvalideException { // complexité en
																// O(n)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		if (r == 1) { // suppression en tete de liste
			tete = tete.noeudSuivant();
		} else { // cas général, r>1
			Noeud<E> p = null, q = tete;
			for (int i = 1; i < r; i++) {
				p = q;
				q = q.noeudSuivant();
			}
			// q désigne l'élément de rang r et p son prédécesseur
			p.noeudSuivant(q.noeudSuivant()); // ca s'appelle une fuite mémoire
												// en C perte de réf!
		}
		lg--;
	}
	@Override
	public void ajouter(int r, E e) throws RangInvalideException { // complexité
																	// en O(n)
		if (r < 1 || r > lg + 1)
			throw new RangInvalideException();
		Noeud<E> n = new Noeud<E>(e);
		if (r == 1) { // ajout en tete de liste
			n.noeudSuivant(tete);
			tete = n;
		} else { // cas général, r>1
			Noeud<E> p = null, q = tete;
			for (int i = 1; i < r; i++) {
				p = q;
				q = q.noeudSuivant();
			}
			// q désigne l'élément de rang r et p son prédécesseur
			p.noeudSuivant(n);
			n.noeudSuivant(q);
		}
		lg++;
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		if (lg != 0) {
			Noeud<E> p = null, q = tete;
			for (int i = 0; i < lg; i++) {
				p = q;
				q = q.noeudSuivant();
				str.append(p.toString());
				str.append(" ");
			}
		}
		return str.toString();

	}
	@Override
	public Iterator<E> iterator() {
		return new ListeEnumeration();
	}
	public static void main(String[] args) {
		ListeChainee<String> liste_string = new ListeChainee<String>();
		liste_string.ajouterEnTete("essai1");
		liste_string.ajouterEnQueue("essai2");
		liste_string.ajouterEnTete("essai3");
		liste_string.ajouterEnQueue("essai4");
		//System.out.println("Liste :" + liste_string);
		Iterator<String> énum =  liste_string.iterator();
		while(énum.hasNext()){
			System.out.println(énum.next());
		}
	}
	
	
	
	
	
	private class ListeEnumeration implements Iterator<E> {
		private Noeud<E> courant;

		public ListeEnumeration() {
			courant = (Noeud<E>) tete;
		}

		public boolean hasNext() {
			return courant != null;
		}

		public E next() throws NoSuchElementException {
			if (hasNext()) {
				E e = courant.valeur();
				courant = courant.noeudSuivant();
				return e;
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			if (hasNext()) {
				courant = courant.noeudSuivant();
			}
			throw new NoSuchElementException();

		}
	}

}
