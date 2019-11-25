package tda_redéfinition;

import tda_redéfinition.exceptions.PileVideException;

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
		return élémentDeTete();
	}

	@Override
	public void déplier() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		supprimerEnTete();
	}

	@Override
	public void empiler(E e) {
		ajouterEnTete(e);
	}

}
