package tda_redéfinition;

import java.util.Iterator;
import java.util.NoSuchElementException;

import tda_redéfinition.exceptions.CléIncomparableException;
import tda_redéfinition.exceptions.CléNonTrouvéeException;

public class ListeOrdonneeChainee<V, C> extends ListeChainee<Element<V, C>>
		implements Table<V, C> {
	protected Comparateur<C> comp;

	public ListeOrdonneeChainee(Comparateur<C> c) {
		comp = c;
	}

	@Override
	public Iterator<Element<V, C>> iterator() {
		return new ListeEnumeration();
	}

	@Override
	public void ajouter(Element<V, C> e) {
		// complexité en O(n)
		if(comp.comparable(e.clé)){
			Noeud<Element<V, C>> n = new Noeud<Element<V, C>>(e);
			if (lg==0) { // ajout en tete de liste
				tete = n;
			} else { // cas général
				Noeud<Element<V, C>> p = null, q = tete;
				while(comp.inférieurOuEgal(q.valeur.clé, n.valeur.clé)&&q.noeudSuivant()!=null){
					p = q;
					q = q.noeudSuivant();
				}	
				// q désigne le rang d'insertion l'élément et p son prédécesseur
				if(q.noeudSuivant()==null) { // deux cas : plus petit ou plus grand que le dernier élément
					if(comp.inférieurOuEgal(q.valeur.clé, n.valeur.clé))
								q.noeudSuivant(n);
					else{
						n.noeudSuivant(q);
						tete = n;
					}
				}else{
					if(p==null){ // ajout en tete
						n.noeudSuivant(q);
						tete = n;
					}else{
						p.noeudSuivant(n);
						n.noeudSuivant(q);
					}
				}
			}
			lg++;
		}
	}

	@Override
	public void supprimer(C clé)throws CléNonTrouvéeException, CléIncomparableException {
		// complexité en O(n)
		if(!comp.comparable(clé))
			throw new CléIncomparableException();
		if (lg==0) { // ajout en tete de liste
				throw new CléNonTrouvéeException();
		} else { // cas général
			Noeud<Element<V, C>> p = null, q = tete;
			while(comp.inférieur(q.valeur.clé, clé)&&q.noeudSuivant()!=null){
				p = q;
				q = q.noeudSuivant();
			}	
			if(comp.égal(q.valeur.clé, clé)){
				// q désigne le rang de suppression et p son prédécesseur
				p.noeudSuivant(q.noeudSuivant());
				lg--;
			}else{
				throw new CléNonTrouvéeException();
			}
		}
	}

	@Override
	public Element<V, C> rechercher(C clé) throws CléNonTrouvéeException {
		if(!comp.comparable(clé))
			throw new CléIncomparableException();
		for(Element<V,C> x : this)
			if(comp.supérieurOuEgal(x.clé(), clé)){
				if(comp.égal(x.clé(),clé)){
					// clé trouvée
					return x;
				}else{
				// clé(élt courant) > clé
					throw new CléNonTrouvéeException();
				}
			}
		//pour tout k 0 < k < longueur(this), clé(ième(this,k))!= c
		throw new CléNonTrouvéeException();
	}
	
	public static void main(String[] args) {

		// les données
		Eleve [] promo = new Eleve [4];

		Eleve el1 = new Eleve("lettre", "elise", new Date(2,9,80), 'A');el1.setMoyenne(10.2);		
		Eleve el2 = new Eleve("pitiot", "paul", new Date(2,9,82), 'B');el2.setMoyenne(16.2);
		Eleve el3 = new Eleve("thérèse", "marie", new Date(10,8,84), 'A');el1.setMoyenne(13.2);
		Eleve el4 = new Eleve("mouly", "xavier", new Date(5,10,79), 'B');el1.setMoyenne(8.2);
		
		promo[0]= el1;promo[1]= el2;promo[2]= el3;promo[3]= el4;
		// tri par ordre alpha du nom
		
		Comparateur<String> comp_alpha = new ComparateurDeCléAlpha();
		Comparateur<Double> comp_double = new ComparateurDeCléDouble();
		
		ListeOrdonneeChainee<Eleve,String> table_comp_nom = new ListeOrdonneeChainee<Eleve,String>(comp_alpha);
		for(int i=0;i<promo.length;i++ ){
			Element<Eleve,String> n = new Element<Eleve,String>(promo[i],promo[i].nom);
			table_comp_nom.ajouter(n);
		}
		
		Iterator<Element<Eleve,String>> énum =  table_comp_nom.iterator();
		System.out.println("tri par ordre des noms : ");
		while(énum.hasNext()){
			System.out.println(énum.next().valeur);
		}
		
		ListeOrdonneeChainee<Eleve,String> table_comp_prenom = new ListeOrdonneeChainee<Eleve,String>(comp_alpha);
		for(int i=0;i<promo.length;i++ ){
			Element<Eleve,String> n = new Element<Eleve,String>(promo[i],promo[i].prenom);
			table_comp_prenom.ajouter(n);
		}
		
		Iterator<Element<Eleve,String>> énum2 =  table_comp_prenom.iterator();
		System.out.println("\ntri par ordre des prénoms : ");
		while(énum2.hasNext()){
			System.out.println(énum2.next().valeur);
		}
		
		ListeOrdonneeChainee<Eleve,Double> table_comp_moy = new ListeOrdonneeChainee<Eleve,Double>(comp_double);
		for(int i=0;i<promo.length;i++ ){
			Element<Eleve,Double> n = new Element<Eleve,Double>(promo[i],promo[i].moyenne);
			table_comp_moy.ajouter(n);
		}
		
		Iterator<Element<Eleve,Double>> énum3 =  table_comp_moy.iterator();
		System.out.println("\ntri par moyenne :  : ");
		while(énum3.hasNext()){
			System.out.println(énum3.next().valeur);
		}
	}
	
	private class ListeEnumeration implements Iterator<Element<V, C>> {
		private Noeud<Element<V, C>> courant;

		public ListeEnumeration() {
			courant = (Noeud<Element<V, C>>) tete;
		}

		public boolean hasNext() {
			return courant != null;
		}

		public Element<V, C> next() throws NoSuchElementException {
			if (hasNext()) {
				Element<V, C> e = courant.valeur();
				courant = courant.noeudSuivant();
				return e;
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			if (hasNext()) {
				courant = courant.noeudSuivant();
			}
			throw new NoSuchElementException();

		}
	}


}
