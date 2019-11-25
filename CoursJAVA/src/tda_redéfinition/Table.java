package tda_red�finition;

import tda_red�finition.exceptions.Cl�NonTrouv�eException;

public interface Table<V, C> extends Iterable<Element<V, C>> {
	public void ajouter(Element<V, C> e);

	public void supprimer(C cl�);

	public Element<V, C> rechercher(C cl�) throws Cl�NonTrouv�eException;
}
