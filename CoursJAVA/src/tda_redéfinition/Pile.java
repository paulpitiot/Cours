package tda_red�finition;

import tda_red�finition.exceptions.PileVideException;

public interface Pile<E> {
	public boolean estVide();

	public E sommet() throws PileVideException;

	public void d�plier() throws PileVideException;

	public void empiler(E e);
}
