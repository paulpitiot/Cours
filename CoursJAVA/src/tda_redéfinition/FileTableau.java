package tda_red�finition;

import tda_red�finition.exceptions.FilePleineException;
import tda_red�finition.exceptions.FileVideException;

public class FileTableau<E> extends ListeTableauCirculaire<E> implements
		File<E> {

	public FileTableau() {
		super();
	}

	public FileTableau(int n) {
		super(n);
	}

	public boolean estPleine() {
		return lg == �l�ments.length;
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
		if (estPleine())
			throw new FilePleineException();
		ajouterEnQueue(e);
	}

}
