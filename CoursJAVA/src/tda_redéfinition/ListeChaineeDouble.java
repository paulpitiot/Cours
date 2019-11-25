package tda_red�finition;

import java.util.Iterator;

import tda_red�finition.exceptions.RangInvalideException;

public class ListeChaineeDouble<E> extends ListeAbstraite<E> implements
		Liste<E> {
	protected int lg;
	protected NoeudDouble<E> tete, queue;

	public int longueur() {
		return lg;
	}

	public E i�me(int r) throws RangInvalideException { // complexit� en O(n)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		NoeudDouble<E> n = tete;
		for (int i = 1; i < r; i++) {
			n = n.noeudSuivant();
		}
		// n d�signe le NoeudDouble de rang r
		return n.valeur();
	}

	@Override
	public void supprimer(int r) throws RangInvalideException {
		// complexit� en O(n) mais en O(1) pour extr�mit�s
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		if (lg == 1) { // un seul �l�ment
			tete = queue = null;
		} else { // plus de deux �l�ments
			if (r == 1) { // suppression en tete de liste
				tete = tete.noeudSuivant();
			} else {
				if (r == lg) { // suppression en queue de liste
					queue = queue.noeudPrecedent();
					queue.noeudSuivant(null);
				} else { // cas g�n�ral, r>1 et r<lg
					NoeudDouble<E> p = null, q = tete;
					for (int i = 1; i < r; i++) {
						p = q;
						q = q.noeudSuivant();
					}
					// q d�signe l'�l�ment de rang r et p son pr�d�cesseur
					q.noeudSuivant().noeudPrecedent(p);
					p.noeudSuivant(q.noeudSuivant()); // ca s'appelle une fuite
														// m�moire en C perte de
														// r�f!
				}
			}
		}
		lg--;
	}

	@Override
	public void ajouter(int r, E e) throws RangInvalideException { // complexit�
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
					// cas g�n�ral, r>1 et r <= lg
					NoeudDouble<E> p = null, q = tete;
					for (int i = 1; i < r; i++) {
						p = q;
						q = q.noeudSuivant();
					}
					// q d�signe l'�l�ment de rang r et p son pr�d�cesseur
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
