package tda_redéfinition;

import java.util.Iterator;

import tda_redéfinition.exceptions.ListePleineException;
import tda_redéfinition.exceptions.RangInvalideException;

public class ListeTableauCirculaire<E> extends ListeAbstraite<E> implements
		Liste<E> {
	protected static final int MAXELEM = 100;
	protected int lg, tete, queue;

	protected E[] éléments;

	public ListeTableauCirculaire() {
		this(MAXELEM);
	}

	@SuppressWarnings("unchecked")
	public ListeTableauCirculaire(int n) {
		éléments = (E[]) new Object[n];
	}

	@Override
	public int longueur() {
		return lg;
	}

	@Override
	public E ième(int r) throws RangInvalideException { // complexité en O(1)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		return éléments[(tete + r-1) % éléments.length];
	}

	@Override
	public void supprimer(int r) throws RangInvalideException {
		// complexité en O(n) mais meilleur que ListeTable dans les pires cas
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		if (r == lg) // supprimer le dernier élément
			queue = queue == 0 ? éléments.length - 1 : --queue;
		else {
			if (r == 1) // supprimer le premier élément
				tete = tete == éléments.length - 1 ? 0 : ++tete;
			else {
				// décaler les éléments
				for (int i = tete + r; i < lg + tete; i++) {
					// i>0
					éléments[(i - 1) % éléments.length] = éléments[i
							% éléments.length];
					queue = queue == 0 ? éléments.length - 1 : --queue;
				}
			}
		}
		lg--;
	}

	@Override
	public void ajouter(int r, E e) throws RangInvalideException {
		// complexité en O(n) mais meilleur que ListeTable dans les pires cas
		if (lg == éléments.length)
			throw new ListePleineException();
		if (r < 1 || r > lg + 1)
			throw new RangInvalideException();
		if (lg == 0){
			éléments[queue] = e;
		}else{
			if (r == lg + 1) { // ajouter en queue
				queue = queue == éléments.length - 1 ? 0 : ++queue;
				éléments[queue] = e;
			} else {
				if (r == 1) { // ajout en tête
					tete = tete == 0 ? éléments.length - 1 : --tete;
					éléments[tete] = e;
				} else {
					// décaler les éléments
					for (int i = lg + tete; i >= r + tete; i--) {
						// i>0
						éléments[i % éléments.length] = éléments[(i - 1)
								% éléments.length];
					}
					// tete + r-1 est l'indice d'insertion
					éléments[(tete + r - 1)% éléments.length] = e;
					queue = queue == éléments.length - 1 ? 0 : ++queue;
				}
			}
		}

		lg++;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public String toString(){
		String tabl_string = "{";
		for (int i = 1; i<lg; i++) {
			tabl_string += ième(i) +", ";
		}
		tabl_string += ième(lg) + "}";
		return tabl_string;
	}
	
	public static void main(String[] args) {
		TestUnitaireAjouterListeTableauCirculaire();
	}
	
	public static void TestUnitaireAjouterListeTableauCirculaire() {
	ListeTableauCirculaire<Integer> liste_tab = new ListeTableauCirculaire<Integer>(10);
	
	// tests ajouter + taille + affichage
	System.out.println("Longueur : " + liste_tab.longueur());
	liste_tab.ajouter(1,1);
	System.out.println(liste_tab);
	System.out.println("Longueur : " + liste_tab.longueur());
	liste_tab.ajouter(1,2);
	System.out.println(liste_tab);
	System.out.println("Longueur : " + liste_tab.longueur());
	liste_tab.ajouter(2,3);
	System.out.println(liste_tab);
	liste_tab.ajouter(2,4);
	System.out.println(liste_tab);
	
	// tests accés
	System.out.println("tableau:");
	for (int i = 1; i <= liste_tab.longueur(); i++) {
		System.out.println( liste_tab.ième(i) );
	}
	
	
	// tests supprimer + taille 
	liste_tab.supprimer(2);
	System.out.println("Longueur : " + liste_tab.longueur());
	
	
	// affiche  {2, 4, 3, 1}
	}
	
	
	
	
	
	
	
	
	

}
