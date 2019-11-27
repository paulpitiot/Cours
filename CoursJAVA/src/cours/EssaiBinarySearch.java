package cours;

import java.util.Arrays;
import java.util.Random;

public class EssaiBinarySearch {

	public static void remplirTableauAl�atoire(int[] tab, int M) {
		for (int i = 0; i < tab.length; i++) {
			// version avec Math.random()
			tab[i] = (int) (Math.random() * M + 1);
			// autre mani�re de tirer un nombre al�atoire : la classe Random
			
		}
	}
	
	public static void remplirTableauAl�atoireUtilisantRandom(int[] tab, int M) {
		// une autre mani�re de tirer un nombre al�atoire : la classe Random
		Random generateurNombre = new Random();
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int) (generateurNombre.nextInt() * M + 1);
			
		}
	}

	public static int RechercheSequentielle(int[] tab, int valeur) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == valeur)
				return i;
		}
		return -1;
	}

	public static void TriBulle(int[] tab) {
		boolean tab_en_ordre = false;
		int taille = tab.length;
		while (!tab_en_ordre) {
			tab_en_ordre = true;
			for (int i = 0; i < taille - 1; i++) {
				if (tab[i] > tab[i + 1]) {
					int memo = tab[i];
					tab[i] = tab[i + 1];
					tab[i + 1] = memo;
					tab_en_ordre = false;
				}
			}
			taille--;
		}
	}

	public static void TriSelection(int[] tab) {
		int indice_max = 0;
		int taille = tab.length;
		for (; taille > 1; taille--) {
			int i = 1;
			while (i < taille) {
				if (tab[i] > tab[indice_max])
					indice_max = i;
				i++;
			}
			int memo = tab[taille - 1];
			tab[taille - 1] = tab[indice_max];
			tab[indice_max] = memo;
		}
	}

	public static void TriInsertion(int tab[]) {
		int i, j;
		int taille = tab.length;
		for (i = 1; i < taille; ++i) {
			int elem = tab[i];
			for (j = i; j > 0 && tab[j - 1] > elem; j--)
				tab[j] = tab[j - 1];
			tab[j] = elem;
		}
	}
	
	public static void testGenerateurPourRemplirTableauAl�atoire() {
		int tailleTableau = 1000000;
		System.out.println("---------------------\n");
		System.out.println("g�n�ration d'un tableau de " + tailleTableau + " cases avec Math.random\n");
		int [] tab = new int[tailleTableau];
		long startTime = System.nanoTime();
		remplirTableauAl�atoire(tab, tailleTableau);
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("Temps n�cessaire : " + estimatedTime / 1000000.0 + " ms");
		
		System.out.println("---------------------\n");
		System.out.println("g�n�ration d'un tableau de " + tailleTableau + " cases avec un g�n�rateur de la classe  Random\n");
		tab = new int[tailleTableau];
		startTime = System.nanoTime();
		remplirTableauAl�atoireUtilisantRandom(tab, tailleTableau);
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("Temps n�cessaire : " + estimatedTime / 1000000.0 + " ms");
		
		
		
		
	}
	public static void comparatifSequentielDichotomie( int tailleTableau){

		
		int[] tab = new int[tailleTableau];
		int[] tab_valeurs_recherch�es = new int[tailleTableau];

		remplirTableauAl�atoire(tab, tailleTableau);
		remplirTableauAl�atoire(tab_valeurs_recherch�es, tailleTableau);

		// System.out.println("Tableau : " + Arrays.toString(tab));
		// System.out.println("Valeur recherch�e : " + valeurRecherch�e);
		System.out.println("---------------------\n");
		System.out.println("Taille tableau :" + tailleTableau + "\n");
		System.out.println("Recherche s�quentielle");
		long startTime = System.nanoTime();
		int cpt = 0;
		for (int val : tab_valeurs_recherch�es)
			if (RechercheSequentielle(tab, val) >= 0)
				cpt++;
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("nb val trouvees : " + cpt);
		System.out.println("Temps n�cessaire : " + estimatedTime / 1000000.0 + " ms");

		System.out.println("Recherche dichotomique");
		startTime = System.nanoTime();
		Arrays.sort(tab);
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("Temps n�cessaire pour le tri: " + estimatedTime / 1000000.0 + " ms");
		cpt = 0;
		for (int val : tab_valeurs_recherch�es)
			if (Arrays.binarySearch(tab, val) >= 0)
				cpt++;
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("nb val trouvees : " + cpt);
		System.out.println("Temps n�cessaire : " + estimatedTime / 1000000.0 + " ms");

	}

	public static void main(String[] args) {

		System.out.println("exercice 19 s�rie 4");
		comparatifSequentielDichotomie(10);
		comparatifSequentielDichotomie(1000);
		comparatifSequentielDichotomie(100000);
		
		// test perf diff�rents types remplissage
		
		testGenerateurPourRemplirTableauAl�atoire() ;
		
	}
}
