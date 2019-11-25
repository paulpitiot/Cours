package tda_redéfinition;

import tda_redéfinition.exceptions.FileVideException;

public interface File<E> {
	public boolean estVide();

	public E premier() throws FileVideException;

	public void défiler() throws FileVideException;

	public void enfiler(E e);
}
