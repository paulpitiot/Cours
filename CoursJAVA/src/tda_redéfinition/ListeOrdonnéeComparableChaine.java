package tda_red�finition;


public class ListeOrdonn�eComparableChaine<E extends Comparable <E>> extends ListeChainee<E> {

		public void ajouter(E e) {			
				if (lg==0) { // ajout en tete de liste
					ajouter(1,e);
				} else { // cas g�n�ral
					Noeud<E> p = null, q = tete;
					int cpt = 1;
					while((e.compareTo(q.valeur) >= 0)&&(q.suivant != null)){
						p = q;
						q = q.noeudSuivant();
						cpt++;
					}	
					// q d�signe le rang d'insertion l'�l�ment et p son pr�d�cesseur
					if(q.noeudSuivant()==null) { // deux cas : plus petit ou plus grand que le dernier �l�ment
						if(e.compareTo(q.valeur) <= 0)
							ajouter(cpt,e);
						else{
							ajouter(cpt+1,e);
						}
					}else{
						ajouter(cpt,e);
					}
				}
		}

		public void supprimer(E e) throws Exception {
			if (lg==0) { // pb liste vide 
					throw new Exception();
			} else { // cas g�n�ral
				Noeud<E> p, q = tete;
				int indice_supp = 0;
				while((e.compareTo(q.valeur) != 0)&&(q.suivant != null)){
					p = q;
					q = q.noeudSuivant();
					indice_supp++;
				}	
				if(e.compareTo(q.valeur) == 0){
					// q d�signe le rang de suppression 
					supprimer(++indice_supp);
				}else{
					throw new Exception();
				}
			}
		}

		public E rechercher(E e) throws Exception {
			for(E x : this)
				if(e.compareTo(x) == 0){
						return x;
				}
			throw new Exception();
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
			
			
			ListeOrdonn�eComparableChaine<Eleve> table_comp_nom = new ListeOrdonn�eComparableChaine<Eleve>();
			for(int i=0;i<promo.length;i++ ){
				table_comp_nom.ajouter(promo[i]);
			}
			
			for(Eleve el:table_comp_nom){
				System.out.println(el);
			}
			
			try {
				table_comp_nom.supprimer(el1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(Eleve el:table_comp_nom){
				System.out.println(el);
			}
		}
		

}
