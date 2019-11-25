package tda_red�finition;

import tda_red�finition.exceptions.ArcException;
import tda_red�finition.exceptions.AreteException;
import tda_red�finition.exceptions.SommetException;

public interface Graphe<S> extends Iterable<S> {
	public int ordre();

	public boolean arete(S s1, S s2);

	public boolean arc(S s1, S s2);

	public int demiDegreInt(S s);

	public int demiDegreExt(S s);

	public int degre(S s);

	public S i�meSucc(S s, int i);

	public void ajouterSommet(S s) throws SommetException;

	public void enleverSommet(S s) throws SommetException;

	public void ajouterArc(S s1, S s2) throws ArcException;

	public void supprimerArc(S s1, S s2) throws ArcException;

	public void ajouterArete(S s1, S s2) throws AreteException;

	public void supprimerArete(S s1, S s2) throws AreteException;

	public Iterable<S> sommetsAdjacents(S s);
}
