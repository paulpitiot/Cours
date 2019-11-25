package tda_redéfinition;

import tda_redéfinition.exceptions.DequeVideException;
import tda_redéfinition.exceptions.FileVideException;

public class DequeChainee<E> extends ListeChaineeDouble<E> implements Deque<E> {

	public DequeChainee() {
		super();
	}

	@Override
	public boolean estVide() {
		return longueur() == 0;
	}

	@Override
	public E extremité(Sens s) throws DequeVideException {
		if (estVide())
			throw new DequeVideException();
		return s == Sens.gauche ? élémentDeQueue() : élémentDeTete();
	}

	@Override
	public void dédéquer(Sens s) throws DequeVideException {
		if (estVide())
			throw new DequeVideException();
		if (s == Sens.gauche) {
			supprimerEnQueue();
		} else { // s= Sens.droite
			supprimerEnTete();
		}
	}

	@Override
	public void endéquer(E e, int s) {
		if (s == 1) {
			ajouterEnQueue(e);
		} else { // s= Sens.droite
			ajouterEnTete(e);
		}
	}

	public void endéquer(E e, Sens s) {
		if (s == Sens.gauche) {
			ajouterEnQueue(e);
		} else { // s= Sens.droite
			ajouterEnTete(e);
		}
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

	public static void main(String[] args) {
		Sens sensCourant = Sens.gauche;
		DequeChainee<String> deque_string = new DequeChainee<String>();
		deque_string.endéquer("essai1", sensCourant);
		deque_string.endéquer("essai2", sensCourant);
		sensCourant = Sens.droit;
		deque_string.endéquer("essai3", sensCourant);
		System.out.println("Deque :" + deque_string);
	}

}
