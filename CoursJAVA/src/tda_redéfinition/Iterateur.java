package tda_redéfinition;

import tda_redéfinition.exceptions.OperationImpossibleException;
import tda_redéfinition.exceptions.PasDElementException;

public interface Iterateur<E> {
		boolean aSuivant();
		E suivant() throws PasDElementException ;
		void retirer() throws OperationImpossibleException ;
}

