package tda_redéfinition;

import java.util.Iterator;

import tda_redéfinition.exceptions.RangInvalideException;

public class ListeChaineeDouble<E> extends ListeAbstraite<E> implements
		Liste<E> {
	protected int lg;
	protected NoeudDouble<E> tete, queue;

	public int longueur() {
		return lg;
	}

	public E ième(int r) throws RangInvalideException { // complexité en O(n)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		NoeudDouble<E> n = tete;
		for (int i = 1; i < r; i++) {
			n = n.noeudSuivant();
		}
		// n désigne le NoeudDouble de rang r
		return n.valeur();
	}

	@Override
	public void supprimer(int r) throws RangInvalideException {
		// complexité en O(n) mais en O(1) pour extrémités
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		if (lg == 1) { // un seul élément
			tete = queue = null;
		} else { // plus de deux éléments
			if (r == 1) { // suppression en tete de liste
				tete = tete.noeudSuivant();
			} else {
				if (r == lg) { // suppression en queue de liste
					queue = queue.noeudPrecedent();
					queue.noeudSuivant(null);
				} else { // cas général, r>1 et r<lg
					NoeudDouble<E> p = null, q = tete;
					for (int i = 1; i < r; i++) {
						p = q;
						q = q.noeudSuivant();
					}
					// q désigne l'élément de rang r et p son prédécesseur
					q.noeudSuivant().noeudPrecedent(p);
					p.noeudSuivant(q.noeudSuivant()); // ca s'appelle une fuite
														// mémoire en C perte de
														// réf!
				}
			}
		}
		lg--;
	}

	@Override
	public void ajouter(int r, E e) throws RangInvalideException { // complexité
																	// en O(n)
		if (r < 1 || r > lg + 1)
			throw new RangInvalideException();
		NoeudDouble<E> n = new NoeudDouble<E>(e);
		if (lg == 0) { // liste vide
			tete = queue = n;
		} else {
			if (r == 1) { // ajout en tete de liste
				tete.noeudPrecedent(n);
				n.noeudSuivant(tete);
				tete = n;
			} else {
				if (r == lg + 1) { // ajout en dernier
					queue.noeudSuivant(n);
					n.noeudPrecedent(queue);
					queue = n;
				} else {
					// cas général, r>1 et r <= lg
					NoeudDouble<E> p = null, q = tete;
					for (int i = 1; i < r; i++) {
						p = q;
						q = q.noeudSuivant();
					}
					// q désigne l'élément de rang r et p son prédécesseur
					p.noeudSuivant(n);
					n.noeudPrecedent(p);
					n.noeudSuivant(q);
					q.noeudPrecedent(n);
				}

			}
		}

		lg++;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		if (lg != 0) {
			NoeudDouble<E> p = null, q = tete;
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
		// TODO Auto-generated method stub
		return null;
	}

}
