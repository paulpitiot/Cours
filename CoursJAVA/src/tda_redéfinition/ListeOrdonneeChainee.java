package tda_red�finition;

import java.util.Iterator;
import java.util.NoSuchElementException;

import tda_red�finition.exceptions.Cl�IncomparableException;
import tda_red�finition.exceptions.Cl�NonTrouv�eException;

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
		// complexit� en O(n)
		if(comp.comparable(e.cl�)){
			Noeud<Element<V, C>> n = new Noeud<Element<V, C>>(e);
			if (lg==0) { // ajout en tete de liste
				tete = n;
			} else { // cas g�n�ral
				Noeud<Element<V, C>> p = null, q = tete;
				while(comp.inf�rieurOuEgal(q.valeur.cl�, n.valeur.cl�)&&q.noeudSuivant()!=null){
					p = q;
					q = q.noeudSuivant();
				}	
				// q d�signe le rang d'insertion l'�l�ment et p son pr�d�cesseur
				if(q.noeudSuivant()==null) { // deux cas : plus petit ou plus grand que le dernier �l�ment
					if(comp.inf�rieurOuEgal(q.valeur.cl�, n.valeur.cl�))
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
	public void supprimer(C cl�)throws Cl�NonTrouv�eException, Cl�IncomparableException {
		// complexit� en O(n)
		if(!comp.comparable(cl�))
			throw new Cl�IncomparableException();
		if (lg==0) { // ajout en tete de liste
				throw new Cl�NonTrouv�eException();
		} else { // cas g�n�ral
			Noeud<Element<V, C>> p = null, q = tete;
			while(comp.inf�rieur(q.valeur.cl�, cl�)&&q.noeudSuivant()!=null){
				p = q;
				q = q.noeudSuivant();
			}	
			if(comp.�gal(q.valeur.cl�, cl�)){
				// q d�signe le rang de suppression et p son pr�d�cesseur
				p.noeudSuivant(q.noeudSuivant());
				lg--;
			}else{
				throw new Cl�NonTrouv�eException();
			}
		}
	}

	@Override
	public Element<V, C> rechercher(C cl�) throws Cl�NonTrouv�eException {
		if(!comp.comparable(cl�))
			throw new Cl�IncomparableException();
		for(Element<V,C> x : this)
			if(comp.sup�rieurOuEgal(x.cl�(), cl�)){
				if(comp.�gal(x.cl�(),cl�)){
					// cl� trouv�e
					return x;
				}else{
				// cl�(�lt courant) > cl�
					throw new Cl�NonTrouv�eException();
				}
			}
		//pour tout k 0 < k < longueur(this), cl�(i�me(this,k))!= c
		throw new Cl�NonTrouv�eException();
	}
	
	public static void main(String[] args) {

		// les donn�es
		Eleve [] promo = new Eleve [4];

		Eleve el1 = new Eleve("lettre", "elise", new Date(2,9,80), 'A');el1.setMoyenne(10.2);		
		Eleve el2 = new Eleve("pitiot", "paul", new Date(2,9,82), 'B');el2.setMoyenne(16.2);
		Eleve el3 = new Eleve("th�r�se", "marie", new Date(10,8,84), 'A');el1.setMoyenne(13.2);
		Eleve el4 = new Eleve("mouly", "xavier", new Date(5,10,79), 'B');el1.setMoyenne(8.2);
		
		promo[0]= el1;promo[1]= el2;promo[2]= el3;promo[3]= el4;
		// tri par ordre alpha du nom
		
		Comparateur<String> comp_alpha = new ComparateurDeCl�Alpha();
		Comparateur<Double> comp_double = new ComparateurDeCl�Double();
		
		ListeOrdonneeChainee<Eleve,String> table_comp_nom = new ListeOrdonneeChainee<Eleve,String>(comp_alpha);
		for(int i=0;i<promo.length;i++ ){
			Element<Eleve,String> n = new Element<Eleve,String>(promo[i],promo[i].nom);
			table_comp_nom.ajouter(n);
		}
		
		Iterator<Element<Eleve,String>> �num =  table_comp_nom.iterator();
		System.out.println("tri par ordre des noms : ");
		while(�num.hasNext()){
			System.out.println(�num.next().valeur);
		}
		
		ListeOrdonneeChainee<Eleve,String> table_comp_prenom = new ListeOrdonneeChainee<Eleve,String>(comp_alpha);
		for(int i=0;i<promo.length;i++ ){
			Element<Eleve,String> n = new Element<Eleve,String>(promo[i],promo[i].prenom);
			table_comp_prenom.ajouter(n);
		}
		
		Iterator<Element<Eleve,String>> �num2 =  table_comp_prenom.iterator();
		System.out.println("\ntri par ordre des pr�noms : ");
		while(�num2.hasNext()){
			System.out.println(�num2.next().valeur);
		}
		
		ListeOrdonneeChainee<Eleve,Double> table_comp_moy = new ListeOrdonneeChainee<Eleve,Double>(comp_double);
		for(int i=0;i<promo.length;i++ ){
			Element<Eleve,Double> n = new Element<Eleve,Double>(promo[i],promo[i].moyenne);
			table_comp_moy.ajouter(n);
		}
		
		Iterator<Element<Eleve,Double>> �num3 =  table_comp_moy.iterator();
		System.out.println("\ntri par moyenne :  : ");
		while(�num3.hasNext()){
			System.out.println(�num3.next().valeur);
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
