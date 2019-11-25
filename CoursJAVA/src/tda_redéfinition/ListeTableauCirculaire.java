package tda_red�finition;

import java.util.Iterator;

import tda_red�finition.exceptions.ListePleineException;
import tda_red�finition.exceptions.RangInvalideException;

public class ListeTableauCirculaire<E> extends ListeAbstraite<E> implements
		Liste<E> {
	protected static final int MAXELEM = 100;
	protected int lg, tete, queue;

	protected E[] �l�ments;

	public ListeTableauCirculaire() {
		this(MAXELEM);
	}

	@SuppressWarnings("unchecked")
	public ListeTableauCirculaire(int n) {
		�l�ments = (E[]) new Object[n];
	}

	@Override
	public int longueur() {
		return lg;
	}

	@Override
	public E i�me(int r) throws RangInvalideException { // complexit� en O(1)
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		return �l�ments[(tete + r-1) % �l�ments.length];
	}

	@Override
	public void supprimer(int r) throws RangInvalideException {
		// complexit� en O(n) mais meilleur que ListeTable dans les pires cas
		if (r < 1 || r > lg)
			throw new RangInvalideException();
		if (r == lg) // supprimer le dernier �l�ment
			queue = queue == 0 ? �l�ments.length - 1 : --queue;
		else {
			if (r == 1) // supprimer le premier �l�ment
				tete = tete == �l�ments.length - 1 ? 0 : ++tete;
			else {
				// d�caler les �l�ments
				for (int i = tete + r; i < lg + tete; i++) {
					// i>0
					�l�ments[(i - 1) % �l�ments.length] = �l�ments[i
							% �l�ments.length];
					queue = queue == 0 ? �l�ments.length - 1 : --queue;
				}
			}
		}
		lg--;
	}

	@Override
	public void ajouter(int r, E e) throws RangInvalideException {
		// complexit� en O(n) mais meilleur que ListeTable dans les pires cas
		if (lg == �l�ments.length)
			throw new ListePleineException();
		if (r < 1 || r > lg + 1)
			throw new RangInvalideException();
		if (lg == 0){
			�l�ments[queue] = e;
		}else{
			if (r == lg + 1) { // ajouter en queue
				queue = queue == �l�ments.length - 1 ? 0 : ++queue;
				�l�ments[queue] = e;
			} else {
				if (r == 1) { // ajout en t�te
					tete = tete == 0 ? �l�ments.length - 1 : --tete;
					�l�ments[tete] = e;
				} else {
					// d�caler les �l�ments
					for (int i = lg + tete; i >= r + tete; i--) {
						// i>0
						�l�ments[i % �l�ments.length] = �l�ments[(i - 1)
								% �l�ments.length];
					}
					// tete + r-1 est l'indice d'insertion
					�l�ments[(tete + r - 1)% �l�ments.length] = e;
					queue = queue == �l�ments.length - 1 ? 0 : ++queue;
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
			tabl_string += i�me(i) +", ";
		}
		tabl_string += i�me(lg) + "}";
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
	
	// tests acc�s
	System.out.println("tableau:");
	for (int i = 1; i <= liste_tab.longueur(); i++) {
		System.out.println( liste_tab.i�me(i) );
	}
	
	
	// tests supprimer + taille 
	liste_tab.supprimer(2);
	System.out.println("Longueur : " + liste_tab.longueur());
	
	
	// affiche  {2, 4, 3, 1}
	}
	
	
	
	
	
	
	
	
	

}
