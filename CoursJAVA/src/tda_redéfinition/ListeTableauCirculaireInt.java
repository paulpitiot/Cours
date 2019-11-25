package tda_red�finition;

public class ListeTableauCirculaireInt implements ListeInt {

	protected static final int MAXELEM = 100;
	protected int iNbElements; // nb �l�ments dans la liste
	protected int iIndiceDebut, iIndiceFin;  // indice de d�but et fin initialement � -1
	protected int[] table;

	public ListeTableauCirculaireInt() {
		this(MAXELEM);
		iNbElements = 0;
		iIndiceDebut = iIndiceFin = -1;
	}

	public ListeTableauCirculaireInt(int n) {
		table = new int[n];
	}

	@Override
	public int longueur() {
		return iNbElements;
	}

	@Override
	public int i�me(int r) {
		if (r < 1 || r > iNbElements) {
			System.out.println("Erreur indice hors �l�ments de la liste");
			return 0;
		} else {
			return table[(iIndiceDebut + r - 1) % table.length];
		}
	}

	@Override
	public void supprimer(int r) {
		// complexit� en O(n) au pire
		// mais mieux que gestion non circulaire pour ajouter en t�te et en
		// queue
		if (iNbElements == 0) {
			System.out.println("Erreur liste vide");
			return;
		}
		if (r < 1 || r > iNbElements) {
			System.out.println("Erreur rang invalide");
			return;
		}
		if (r == iNbElements) // supprimer le dernier �l�ment
			iIndiceFin = iIndiceFin == 0 ? table.length - 1 : --iIndiceFin;
		else {
			if (r == 1) // supprimer le premier �l�ment
				iIndiceDebut = iIndiceDebut == table.length - 1 ? 0 : ++iIndiceDebut;
			else {
				// d�caler les �l�ments
				for (int i = iIndiceDebut + r; i < iNbElements + iIndiceDebut; i++) {
					// i>0
					table[(i - 1) % table.length] = table[i % table.length];
					iIndiceFin = iIndiceFin == 0 ? table.length - 1 : --iIndiceFin;
				}
			}
		}
		iNbElements--;
	}

	@Override
	public void ajouter(int r, int e) {
		// complexit� en O(n) au pire
		// mais mieux que gestion non circulaire pour ajouter en t�te et en
		// queue
		if (iNbElements == table.length) {
			System.out.println("Erreur tableau plein");
			return;
		}
		if (r < 1 || r > iNbElements + 1) {
			System.out.println("Erreur rang invalide");
			return;
		}
		if (iNbElements == 0) {
			table[iIndiceFin] = e;
		} else {
			if (r == iNbElements + 1) { // ajouter en queue
				iIndiceFin = iIndiceFin == table.length - 1 ? 0 : ++iIndiceFin;
				table[iIndiceFin] = e;
			} else {
				if (r == 1) { // ajout en t�te
					iIndiceDebut = iIndiceDebut == 0 ? table.length - 1 : --iIndiceDebut;
					table[iIndiceDebut] = e;
				} else {
					// d�caler les �l�ments
					for (int i = iNbElements + iIndiceDebut; i >= r + iIndiceDebut; i--) {
						// i>0
						table[i % table.length] = table[(i - 1) % table.length];
					}
					// tete + r-1 est l'indice d'insertion
					table[(iIndiceDebut + r - 1) % table.length] = e;
					iIndiceFin = iIndiceFin == table.length - 1 ? 0 : ++iIndiceFin;
				}
			}
		}

		iNbElements++;
	}

	public String toString() {
		String tabl_string = "{";
		for (int i = 1; i < iNbElements; i++) {
			tabl_string += i�me(i) + ", ";
		}
		tabl_string += i�me(iNbElements) + "}";
		return tabl_string;
	}

	public static void main(String[] args) {
		TestUnitaireAjouterListeTableauCirculaireInt();
	}

	public static void TestUnitaireAjouterListeTableauCirculaireInt() {
		ListeTableauCirculaireInt liste_tab = new ListeTableauCirculaireInt(4);

		// tests ajouter + taille + affichage
		System.out.println("Longueur : " + liste_tab.longueur());
		// affiche Longueur : 0
		liste_tab.ajouter(1, 1);
		System.out.println(liste_tab);
		// affiche {1}
		System.out.println("Longueur : " + liste_tab.longueur());
		// affiche Longueur : 1
		liste_tab.ajouter(1, 2);
		System.out.println(liste_tab);
		// affiche {2, 1}
		liste_tab.ajouter(4, 1);
		// affiche Erreur rang invalide

		System.out.println("Longueur : " + liste_tab.longueur());
		// affiche Longueur : 2
		liste_tab.ajouter(2, 3);
		System.out.println(liste_tab);
		// affiche {2, 3, 1}
		liste_tab.ajouter(2, 4);
		System.out.println(liste_tab);
		// affiche {2, 4, 3, 1}

		liste_tab.ajouter(1, 1);
		// affiche Erreur tableau plein

		// tests acc�s
		System.out.println("tableau:");
		for (int i = 1; i <= liste_tab.longueur(); i++) {
			System.out.println(liste_tab.i�me(i));
		}
		// affiche verticalement 2 4 3 1
		liste_tab.i�me(-1);
		// affiche erreur indice hors �l�ments de la liste
		liste_tab.i�me(5);
		// affiche erreur indice hors �l�ments de la liste

		// tests supprimer + taille
		liste_tab.supprimer(2);
		System.out.println(liste_tab);
		// affiche {2, 3, 1}
		System.out.println("Longueur : " + liste_tab.longueur());
		// affiche Longueur : 3

	}

}
