package tda_redéfinition;

import tda_redéfinition.exceptions.CléNonTrouvéeException;

public interface Table<V, C> extends Iterable<Element<V, C>> {
	public void ajouter(Element<V, C> e);

	public void supprimer(C clé);

	public Element<V, C> rechercher(C clé) throws CléNonTrouvéeException;
}
