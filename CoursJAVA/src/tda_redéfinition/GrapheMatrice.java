package tda_redéfinition;

/*
 * import java.util.Iterator; import java.util.NoSuchElementException;
 * 
 * import tda_redéfinition.exceptions.ArcException; import
 * tda_redéfinition.exceptions.AreteException; import
 * tda_redéfinition.exceptions.FinEnumerationException; import
 * tda_redéfinition.exceptions.SommetException;
 * 
 * public class GrapheMatrice<S> implements Graphe<S>{ protected
 * SommetsAdjacentsEnumeration<S> SommetsAdj; protected int nbSommets; // ordre
 * du graphe protected boolean [][] matI; public GrapheMatrice() { nbSommets =
 * 0; matI = null; }
 * 
 * @Override public Iterator<S> iterator() { return
 * SommetsAdjacentsEnumeration(); }
 * 
 * @Override public int ordre() { return nbSommets; }
 * 
 * @Override public boolean arete(S s1, S s2) { return
 * matI[numero(s1)][numero(s2)]; }
 * 
 * @Override public boolean arc(S s1, S s2) { // TODO Auto-generated method stub
 * return false; }
 * 
 * @Override public int demiDegreInt(S s) { // TODO Auto-generated method stub
 * return 0; }
 * 
 * @Override public int demiDegreExt(S s) { // TODO Auto-generated method stub
 * return 0; }
 * 
 * @Override public int degre(S s) { // TODO Auto-generated method stub return
 * 0; }
 * 
 * @Override public S ièmeSucc(S s, int i) { // TODO Auto-generated method stub
 * return null; }
 * 
 * @Override public void ajouterSommet(S s) throws SommetException { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void enleverSommet(S s) throws SommetException { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void ajouterArc(S s1, S s2) throws ArcException { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void supprimerArc(S s1, S s2) throws ArcException { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void ajouterArete(S s1, S s2) throws AreteException { //
 * TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public void supprimerArete(S s1, S s2) throws AreteException { //
 * TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public Iterable<S> sommetsAdjacents(S s) { // TODO Auto-generated
 * method stub return null; }
 * 
 * 
 * private class SommetsAdjacentsEnumeration<S> implements Iterable<S>{ private
 * Iterator<S> enumSommets; public SommetsAdjacentsEnumeration(S s){ //
 * construire la liste des successeurs de s Liste<S> listeSom= new
 * ListeChaineeDouble<S>(); int i=0; do{ if(matI[numero(s)][i]){
 * listeSom.ajouter(listeSom.longueur()+1, sommet(i)); } }while(++i<nbSommets);
 * enumSommets=listeSom.iterator(); } public boolean hasNext(){ return
 * enumSommets.hasNext(); } public S next() throws NoSuchElementException {
 * if(hasNext()) return enumSommets.next(); throw new FinEnumerationException();
 * }
 * 
 * @Override public Iterator<S> iterator() { return enumSommets; }
 * 
 * }
 * 
 * }
 */