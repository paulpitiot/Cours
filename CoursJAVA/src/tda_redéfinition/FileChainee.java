package tda_red�finition;

import tda_red�finition.exceptions.FileVideException;

public class FileChainee<E> extends ListeChaineeDouble<E> implements File<E> {

	public FileChainee() {
		super();
	}

	@Override
	public boolean estVide() {
		return longueur() == 0;
	}

	@Override
	public E premier() throws FileVideException {
		if (estVide())
			throw new FileVideException();
		return �l�mentDeTete();
	}

	@Override
	public void d�filer() throws FileVideException {
		if (estVide())
			throw new FileVideException();
		supprimerEnTete();
	}

	@Override
	public void enfiler(E e) {
		ajouterEnQueue(e);
	}

}
