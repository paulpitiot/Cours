package tda_red�finition;

import tda_red�finition.exceptions.PileVideException;
import tda_red�finition.exceptions.PilePleineException;

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
		return lg == �l�ments.length;
	}

	@Override
	public E sommet() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		return �l�mentDeQueue();
	}

	@Override
	public void d�plier() throws PileVideException {
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
