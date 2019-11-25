package tda_redéfinition;

import tda_redéfinition.exceptions.PileVideException;

public interface Pile<E> {
	public boolean estVide();

	public E sommet() throws PileVideException;

	public void déplier() throws PileVideException;

	public void empiler(E e);
}
