package tda_redéfinition;

import tda_redéfinition.exceptions.DequeVideException;

public interface Deque<E> {
	public enum Sens {
		gauche, droit
	}

	public boolean estVide();

	public E extremité(Sens s) throws DequeVideException;

	public void dédéquer(Sens s) throws DequeVideException;

	public void endéquer(E e, int s);

}
