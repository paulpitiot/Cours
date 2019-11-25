package tda_red�finition;

import java.util.Iterator;
import java.util.NoSuchElementException;

import tda_red�finition.exceptions.ListePleineException;
import tda_red�finition.exceptions.RangInvalideException;

public class ListeTableau<E> extends ListeAbstraite<E> implements Liste<E> {
	protected static final int MAXELEM = 100;
	protected int lg;
	protected E[] �l�ments;

	public ListeTableau() {
		this(MAXELEM);
	}

	@SuppressWarnings("unchecked")
	public ListeTableau(int n) {
		�l�ments = (E[]) new Object[n];
	}

	@Override
	public int longueur() {
		return lg;
	}

	@Override
	public E i�me(int r) throws RangInvalideException { // complexit� en O(1)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		return �l�ments[r - 1];
	}

	@Override
	public void supprimer(int r) throws RangInvalideException { // complexit� en
																// O(n)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		// d�caler les �l�ments vers la gauche
		for (int i = r; i < lg; i++) {
			�l�ments[i - 1] = �l�ments[i];
		}
		lg--;
	}

	@Override
	public void ajouter(int r, E e) throws RangInvalideException { // complexit�
																	// en O(n)
		if (lg == �l�ments.length)
			throw new ListePleineException();
		if (r < 1 || r > lg + 1)
			throw new RangInvalideException();
		// d�caler les �l�ments vers la droite
		for (int i = lg; i >= r; i--) {
			�l�ments[i] = �l�ments[i - 1];
		}
		// r-1 est l'indice de l'�l�ment � ajouter
		�l�ments[r - 1] = e;
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
				return �l�ments[courant-1];
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
