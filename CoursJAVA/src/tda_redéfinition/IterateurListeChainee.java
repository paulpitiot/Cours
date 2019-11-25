package tda_redéfinition;

import tda_redéfinition.exceptions.OperationImpossibleException;
import tda_redéfinition.exceptions.PasDElementException;

public class IterateurListeChainee<E> implements Iterateur<E> {
	
	Noeud<E> elemSuivant;

	public IterateurListeChainee(ListeChainee<E> list){
		elemSuivant = list.tete;
	}
	@Override
	public boolean aSuivant() {
		if (elemSuivant != null)
			return true;
		return false;
	}
	@Override
	public E suivant() throws PasDElementException {
		if (elemSuivant != null){
			E valeurCourant = elemSuivant.valeur();
			elemSuivant = elemSuivant.noeudSuivant();
			return valeurCourant;
		}else{
			throw new PasDElementException("fin de liste atteint");
		}
		
	}
	@Override
	public void retirer() throws OperationImpossibleException {
		// TODO Auto-generated method stub

	}

}





 