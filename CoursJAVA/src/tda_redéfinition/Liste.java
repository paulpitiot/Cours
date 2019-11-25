package tda_red�finition;

import java.util.Iterator;

import tda_red�finition.exceptions.RangInvalideException;

public interface Liste<E> extends Iterable<E> {
	public int longueur();

	public E i�me(int r) throws RangInvalideException;

	public void supprimer(int r) throws RangInvalideException;

	public void ajouter(int r, E e) throws RangInvalideException;

	public Iterator<E> iterator();
}
