package tda_redéfinition;

import tda_redéfinition.exceptions.PileVideException;
import tda_redéfinition.exceptions.PilePleineException;

public class PileTableau<E> extends ListeTableau<E> implements Pile<E> {

	public PileTableau() {
		this(MAXELEM);
	}

	public PileTableau(int n) {
		super(n);
	}

	@Override
	public boolean estVide() {
		return longueur() == 0;
	}

	public boolean estPleine() {
		return lg == éléments.length;
	}

	@Override
	public E sommet() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		return élémentDeQueue();
	}

	@Override
	public void déplier() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		supprimerEnQueue();
	}

	@Override
	public void empiler(E e) {
		if (estPleine())
			throw new PilePleineException();
		ajouterEnQueue(e);
	}

}
