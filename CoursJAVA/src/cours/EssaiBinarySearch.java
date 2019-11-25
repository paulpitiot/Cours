package cours;

import java.util.Arrays;

public class EssaiBinarySearch {

	public static void RemplirTableauAléatoire(int[] tab, int M) {
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int) (Math.random() * M + 1);
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

	public static void main(String[] args) {
		// System.out.println("Saisir taille tableau (N) ");
		// for (int i = 1 ; i <= 1000000; i *=1000){
		// if (i==1)
		// i=10;
		// int N = i;
		//
		// int [] tab = new int[N];
		// int [] tab_valeurs_recherchées = new int[N];
		//
		// RemplirTableauAléatoire(tab, N);
		// RemplirTableauAléatoire(tab_valeurs_recherchées, N);
		//
		// //System.out.println("Tableau : " + Arrays.toString(tab));
		// //System.out.println("Valeur recherchée : " + valeurRecherchée);
		// System.out.println("Taille tableau :" + i);
		// System.out.println("");
		// System.out.println("Recherche séquentielle");
		// long startTime = System.nanoTime();
		// int cpt = 0;
		// for(int val : tab_valeurs_recherchées)
		// if (RechercheSequentielle(tab, val)>=0 )
		// cpt++;
		// long estimatedTime = System.nanoTime() - startTime;
		// System.out.println("nb val trouvees : " + cpt);
		// System.out.println("Temps nécessaire : " + estimatedTime/1000000.0 +"
		// ms" );
		//
		// System.out.println("Recherche dichotomique");
		// startTime = System.nanoTime();
		// Arrays.sort(tab);
		// estimatedTime = System.nanoTime() - startTime;
		// System.out.println("Temps nécessaire pour le tri: " +
		// estimatedTime/1000000.0 +" ms" );
		// cpt = 0;
		// for(int val : tab_valeurs_recherchées)
		// if (Arrays.binarySearch(tab, val)>=0 )
		// cpt++;
		// estimatedTime = System.nanoTime() - startTime;
		// System.out.println("nb val trouvees : " + cpt);
		// System.out.println("Temps nécessaire : " + estimatedTime/1000000.0 +"
		// ms" );
		// if (i==10)
		// i=1;
		// }
		int i = 10;
		while (i <= 100000) {
			int N = i;

			int[] tab = new int[N];
			RemplirTableauAléatoire(tab, N);

			System.out.println("Taille tableau :" + i);
			System.out.println("");
			System.out.println("tri sélection");
			long startTime = System.nanoTime();
			TriSelection(tab);
			long estimatedTime = System.nanoTime() - startTime;
			System.out.println("Temps nécessaire : " + estimatedTime / 1000000.0 + " ms");

			System.out.println("");
			System.out.println("tri bulle");
			startTime = System.nanoTime();
			TriBulle(tab);
			estimatedTime = System.nanoTime() - startTime;
			System.out.println("Temps nécessaire : " + estimatedTime / 1000000.0 + " ms");

			System.out.println("");
			System.out.println("tri insertion");
			startTime = System.nanoTime();
			TriInsertion(tab);
			estimatedTime = System.nanoTime() - startTime;
			System.out.println("Temps nécessaire : " + estimatedTime / 1000000.0 + " ms");

			System.out.println("");
			System.out.println("tri API JAVA");
			startTime = System.nanoTime();
			Arrays.sort(tab);
			estimatedTime = System.nanoTime() - startTime;
			System.out.println("Temps nécessaire : " + estimatedTime / 1000000.0 + " ms");
			i *= 100;
		}

	}

}
