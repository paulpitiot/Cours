package tda_redéfinition;

import tda_redéfinition.exceptions.FileVideException;

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
		return élémentDeTete();
	}

	@Override
	public void défiler() throws FileVideException {
		if (estVide())
			throw new FileVideException();
		supprimerEnTete();
	}

	@Override
	public void enfiler(E e) {
		ajouterEnQueue(e);
	}

}
