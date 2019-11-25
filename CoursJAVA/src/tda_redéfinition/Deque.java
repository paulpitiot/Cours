package tda_red�finition;

import tda_red�finition.exceptions.DequeVideException;

public interface Deque<E> {
	public enum Sens {
		gauche, droit
	}

	public boolean estVide();

	public E extremit�(Sens s) throws DequeVideException;

	public void d�d�quer(Sens s) throws DequeVideException;

	public void end�quer(E e, int s);

}
