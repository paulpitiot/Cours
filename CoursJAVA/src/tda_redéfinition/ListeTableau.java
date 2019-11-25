package tda_redéfinition;

import java.util.Iterator;
import java.util.NoSuchElementException;

import tda_redéfinition.exceptions.ListePleineException;
import tda_redéfinition.exceptions.RangInvalideException;

public class ListeTableau<E> extends ListeAbstraite<E> implements Liste<E> {
	protected static final int MAXELEM = 100;
	protected int lg;
	protected E[] éléments;

	public ListeTableau() {
		this(MAXELEM);
	}

	@SuppressWarnings("unchecked")
	public ListeTableau(int n) {
		éléments = (E[]) new Object[n];
	}

	@Override
	public int longueur() {
		return lg;
	}

	@Override
	public E ième(int r) throws RangInvalideException { // complexité en O(1)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		return éléments[r - 1];
	}

	@Override
	public void supprimer(int r) throws RangInvalideException { // complexité en
																// O(n)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		// décaler les éléments vers la gauche
		for (int i = r; i < lg; i++) {
			éléments[i - 1] = éléments[i];
		}
		lg--;
	}

	@Override
	public void ajouter(int r, E e) throws RangInvalideException { // complexité
																	// en O(n)
		if (lg == éléments.length)
			throw new ListePleineException();
		if (r < 1 || r > lg + 1)
			throw new RangInvalideException();
		// décaler les éléments vers la droite
		for (int i = lg; i >= r; i--) {
			éléments[i] = éléments[i - 1];
		}
		// r-1 est l'indice de l'élément à ajouter
		éléments[r - 1] = e;
		lg++;
	}

	@Override
	public Iterator<E> iterator() {
		return new ListeEnumeration();
	}
	private class ListeEnumeration implements Iterator<E> {
		private int courant;

		public ListeEnumeration() {
			courant = 0;
		}

		public boolean hasNext() {
			return courant+1 >= lg;
		}

		public E next() throws NoSuchElementException {
			if (hasNext()) {
				courant++;
				return éléments[courant-1];
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			if (hasNext()) {
				courant++;
			}
			throw new NoSuchElementException();

		}
	}
}
