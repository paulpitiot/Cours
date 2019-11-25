package tda_redéfinition;

import java.util.Iterator;

import tda_redéfinition.exceptions.RangInvalideException;

public interface Liste<E> extends Iterable<E> {
	public int longueur();

	public E ième(int r) throws RangInvalideException;

	public void supprimer(int r) throws RangInvalideException;

	public void ajouter(int r, E e) throws RangInvalideException;

	public Iterator<E> iterator();
}
