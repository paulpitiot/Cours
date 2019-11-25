package tda_red�finition;

import tda_red�finition.exceptions.OperationImpossibleException;
import tda_red�finition.exceptions.PasDElementException;

public interface Iterateur<E> {
		boolean aSuivant();
		E suivant() throws PasDElementException ;
		void retirer() throws OperationImpossibleException ;
}

