package tda_red�finition;

import tda_red�finition.exceptions.PileVideException;

public class PileChainee<E> extends ListeChainee<E> implements Pile<E> {

	public PileChainee() {
		super();
	}

	@Override
	public boolean estVide() {
		return longueur() == 0;
	}

	@Override
	public E sommet() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		return �l�mentDeTete();
	}

	@Override
	public void d�plier() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		supprimerEnTete();
	}

	@Override
	public void empiler(E e) {
		ajouterEnTete(e);
	}

}
