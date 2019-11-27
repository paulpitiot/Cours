package cours;

import java.util.Arrays;
import java.util.Random;

public class EssaiBinarySearch {

	public static void remplirTableauAléatoire(int[] tab, int M) {
		for (int i = 0; i < tab.length; i++) {
			// version avec Math.random()
			tab[i] = (int) (Math.random() * M + 1);
			// autre manière de tirer un nombre aléatoire : la classe Random
			
		}
	}
	
	public static void remplirTableauAléatoireUtilisantRandom(int[] tab, int M) {
		// une autre manière de tirer un nombre aléatoire : la classe Random
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
	
	public static void testGenerateurPourRemplirTableauAléatoire() {
		int tailleTableau = 1000000;
		System.out.println("---------------------\n");
		System.out.println("génération d'un tableau de " + tailleTableau + " cases avec Math.random\n");
		int [] tab = new int[tailleTableau];
		long startTime = System.nanoTime();
		remplirTableauAléatoire(tab, tailleTableau);
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("Temps nécessaire : " + estimatedTime / 1000000.0 + " ms");
		
		System.out.println("---------------------\n");
		System.out.println("génération d'un tableau de " + tailleTableau + " cases avec un générateur de la classe  Random\n");
		tab = new int[tailleTableau];
		startTime = System.nanoTime();
		remplirTableauAléatoireUtilisantRandom(tab, tailleTableau);
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("Temps nécessaire : " + estimatedTime / 1000000.0 + " ms");
		
		
		
		
	}
	public static void comparatifSequentielDichotomie( int tailleTableau){

		
		int[] tab = new int[tailleTableau];
		int[] tab_valeurs_recherchées = new int[tailleTableau];

		remplirTableauAléatoire(tab, tailleTableau);
		remplirTableauAléatoire(tab_valeurs_recherchées, tailleTableau);

		// System.out.println("Tableau : " + Arrays.toString(tab));
		// System.out.println("Valeur recherchée : " + valeurRecherchée);
		System.out.println("---------------------\n");
		System.out.println("Taille tableau :" + tailleTableau + "\n");
		System.out.println("Recherche séquentielle");
		long startTime = System.nanoTime();
		int cpt = 0;
		for (int val : tab_valeurs_recherchées)
			if (RechercheSequentielle(tab, val) >= 0)
				cpt++;
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("nb val trouvees : " + cpt);
		System.out.println("Temps nécessaire : " + estimatedTime / 1000000.0 + " ms");

		System.out.println("Recherche dichotomique");
		startTime = System.nanoTime();
		Arrays.sort(tab);
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("Temps nécessaire pour le tri: " + estimatedTime / 1000000.0 + " ms");
		cpt = 0;
		for (int val : tab_valeurs_recherchées)
			if (Arrays.binarySearch(tab, val) >= 0)
				cpt++;
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("nb val trouvees : " + cpt);
		System.out.println("Temps nécessaire : " + estimatedTime / 1000000.0 + " ms");

	}

	public static void main(String[] args) {

		System.out.println("exercice 19 série 4");
		comparatifSequentielDichotomie(10);
		comparatifSequentielDichotomie(1000);
		comparatifSequentielDichotomie(100000);
		
		// test perf différents types remplissage
		
		testGenerateurPourRemplirTableauAléatoire() ;
		
	}
}
