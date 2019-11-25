package tda_red�finition;

import java.util.Iterator;
import java.util.NoSuchElementException;

import tda_red�finition.exceptions.RangInvalideException;

public class ListeChainee<E> extends ListeAbstraite<E> implements Liste<E> {
	protected int lg;
	protected Noeud<E> tete;
	public int longueur() {
		return lg;
	}
	public E i�me(int r) throws RangInvalideException { // complexit� en O(n)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		Noeud<E> n = tete;
		for (int i = 1; i < r; i++) {
			n = n.noeudSuivant();
		}
		// n d�signe le noeud de rang r
		return n.valeur();
	}
	public void supprimer(int r) throws RangInvalideException { // complexit� en
																// O(n)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		if (r == 1) { // suppression en tete de liste
			tete = tete.noeudSuivant();
		} else { // cas g�n�ral, r>1
			Noeud<E> p = null, q = tete;
			for (int i = 1; i < r; i++) {
				p = q;
				q = q.noeudSuivant();
			}
			// q d�signe l'�l�ment de rang r et p son pr�d�cesseur
			p.noeudSuivant(q.noeudSuivant()); // ca s'appelle une fuite m�moire
												// en C perte de r�f!
		}
		lg--;
	}
	@Override
	public void ajouter(int r, E e) throws RangInvalideException { // complexit�
																	// en O(n)
		if (r < 1 || r > lg + 1)
			throw new RangInvalideException();
		Noeud<E> n = new Noeud<E>(e);
		if (r == 1) { // ajout en tete de liste
			n.noeudSuivant(tete);
			tete = n;
		} else { // cas g�n�ral, r>1
			Noeud<E> p = null, q = tete;
			for (int i = 1; i < r; i++) {
				p = q;
				q = q.noeudSuivant();
			}
			// q d�signe l'�l�ment de rang r et p son pr�d�cesseur
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
		Iterator<String> �num =  liste_string.iterator();
		while(�num.hasNext()){
			System.out.println(�num.next());
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
