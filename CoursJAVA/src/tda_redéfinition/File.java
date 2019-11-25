package tda_red�finition;

import tda_red�finition.exceptions.FileVideException;

public interface File<E> {
	public boolean estVide();

	public E premier() throws FileVideException;

	public void d�filer() throws FileVideException;

	public void enfiler(E e);
}
