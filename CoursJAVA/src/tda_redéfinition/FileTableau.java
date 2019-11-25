package tda_redéfinition;

import tda_redéfinition.exceptions.FilePleineException;
import tda_redéfinition.exceptions.FileVideException;

public class FileTableau<E> extends ListeTableauCirculaire<E> implements
		File<E> {

	public FileTableau() {
		super();
	}

	public FileTableau(int n) {
		super(n);
	}

	public boolean estPleine() {
		return lg == éléments.length;
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
		if (estPleine())
			throw new FilePleineException();
		ajouterEnQueue(e);
	}

}
