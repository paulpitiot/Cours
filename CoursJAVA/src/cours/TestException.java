package cours;

import java.util.Arrays;
import java.util.Random;

public class TestException {

	public static void td1_exo8() {
		// Exo 8
		// constantes (pour l'évolutivité)
		final int TAILLETABLEAU = 10;
		// pour le tirage aléatoire
		final int BORNEINF = -5;
		final int TAILLEINTERVAL = 10;

		// création/remplissage du tableau
		int[] tab = new int[TAILLETABLEAU];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int) (Math.random() * (TAILLEINTERVAL + 1)) + BORNEINF;
			// random -> [0;1[ -> [0;1[ * TAILLEINTERVAL+1 -> [0;TAILLEINTERVAL]
		}
		// affichage
		System.out.println(Arrays.toString(tab));

		// partie suivante
//		
//		 * // j'utilise ici une autre façon de générer des nombres aléatoirement
//		 // avec un objet de la classe Random 
//		 Random rand = new Random(); 
//		 for(int i = 0; i<10; i++){
//			 int i1 = rand.nextInt(11); 
//			 int i2 = rand.nextInt(11); // rand peut lever une Exception  java.lang.IllegalArgumentException: bound must be positive 
//			 // mais ici on lui envoie 11 donc aucune chance de lever l'exception
//			 System.out.println("i1= " + i1); 
//			 System.out.println("i2= " + i2);
//			 System.out.println("tab[i1]/tab[i2]= " + tab[i1] / tab[i2])); 
//			 // Exception java.lang.ArithmeticException: / by zero ou 
//			 // Exception java.lang.ArrayIndexOutOfBoundsException: 10 si i1 ou i2 = 10 } 

		int i1 = 0, i2 = 0;
		try {
			Random rand = new Random();
			for (int i = 0; i < 10; i++) {
				i1 = rand.nextInt(11);
				i2 = rand.nextInt(11);// rand peut lever une Exception  java.lang.IllegalArgumentException: bound must be positive 
   			    // mais ici on lui envoie 11 donc aucune chance de lever l'exception
				System.out.println("i1= " + i1);
				System.out.println("i2= " + i2);
				System.out.println("tab[i1]/tab[i2]= " + tab[i1] / tab[i2]);
				// Exception java.lang.ArithmeticException: / by zero ou
				// Exception java.lang.ArrayIndexOutOfBoundsException: 10 si i1
				// ou i2 = 10
			}
		} catch (ArithmeticException e) {
			// traitement de l'erreur de division par zéro
			System.out.println("Erreur division par zéro !"); // message
																// personnalisé
			System.out.println(e.getMessage()); // message générique
			e.printStackTrace(); // affichage pile d'appels

		} catch (ArrayIndexOutOfBoundsException e) {
			// traitement de l'exception issue de nextInt
			System.out.println("Erreur indice hors limite ! :");
			System.out.print(((i1 >= 0) && (i1 < 10)) ? "i2 = " : "i1 = ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			// traitement de l'exception générique
			System.out.println("Erreur générique");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void td1_exo9() {
		// Exo 9
		// constantes (du coup intérêt de l'avoir fait à l'exo précédent pour
		// l'évolutivité)
		final int TAILLETABLEAU = 10;
		// pour le tirage aléatoire
		final int BORNEINF = -4;
		final int TAILLEINTERVAL = 12;

		// création/remplissage du tableau
		int[] tab = new int[TAILLETABLEAU];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int) (Math.random() * (TAILLEINTERVAL + 1)) + BORNEINF;
			// random -> [0;1[ -> [0;1[ * TAILLEINTERVAL+1 -> [0;TAILLEINTERVAL]
		}
		// affichage
		System.out.println(Arrays.toString(tab));

		double resultat = 0.0;
		try {

			resultat = Calcul(tab);

		} catch (Exception e) {
			// traitement de l'exception générique
			System.out.println("Erreur générique");
			e.printStackTrace();
		}
		System.out.printf("Résultat = %.3f", resultat);
	}

	static public double Calcul(int tbl[]) throws Exception {
		int i1 = 0, i2 = 0;

		// création des compteurs
		int nb_calcul_réussis = 0;
		int nb_division_zero = 0;
		int nb_indice_hors_limite = 0;
		double calcul, moyenne_calcul = 0.0;

		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			i1 = rand.nextInt(11);
			i2 = rand.nextInt(11);
			try {
				moyenne_calcul +=  calcul =  tbl[i1] / tbl[i2];
				System.out.println("calcul réussi  : tbl["+ i1+ "] = " + tbl[i1] + " / tbl["+i2+ "] = " + tbl[i2] + " => " + calcul );
				nb_calcul_réussis++;
			} catch (ArithmeticException e) {
				// traitement de l'erreur de division par zéro
				System.out.println("DIVISION PAR ZERO : tbl[i1] = " + tbl[i1] + " tbl[i2] = " + tbl[i2]); 
				nb_division_zero++;

			} catch (ArrayIndexOutOfBoundsException e) {
				// traitement de l'exception indice hors limites
				System.out.println("INDICE HORS LIMITE : i1 = " + i1 + " i2 = " + i2);
				nb_indice_hors_limite++;
			} catch (Exception e) {
				// traitement de l'exception générique
				System.out.println("Erreur générique");
				throw new Exception(e.getMessage());
			}
		}
		moyenne_calcul /= nb_calcul_réussis;
		System.out.println("\n\n" + nb_calcul_réussis + " calculs corrects");
		System.out.println(nb_division_zero + " DIVISION PAR ZERO");
		System.out.println(nb_indice_hors_limite + " INDICE HORS LIMITE");
		System.out.println("\nmoyenne=" + moyenne_calcul);
		return moyenne_calcul;

	}

	public static void td1_exo10() {
		// Exo 10
		// constantes 
		final int TAILLETABLEAU = 10;
		// pour le tirage aléatoire
		final int BORNEINF = -4;
		final int TAILLEINTERVAL = 12;

		// création/remplissage du tableau
		int[] tab = new int[TAILLETABLEAU];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int) (Math.random() * (TAILLEINTERVAL + 1)) + BORNEINF;
			// random -> [0;1[ -> [0;1[ * TAILLEINTERVAL+1 -> [0;TAILLEINTERVAL]
		}
		// affichage
		System.out.println(Arrays.toString(tab));
		
		boolean poursuite = true;
		double resultat = 0.0;
		while(poursuite){
			try {
				resultat = CalculExo10(tab);
				System.out.printf("moyenne = %1$.3f", resultat);
				poursuite = false;
			} catch (Exception e) {
				// traitement de l'exception générique
				System.out.println("EXCEPTION : " + e.getMessage());
				String saisie;
				do{
					System.out.println("Voulez-vous recommencer ? (o/n)" );
					saisie = Clavier.lireString();
				}while((saisie.charAt(0) != 'o') && (saisie.charAt(0) != 'n'));

				if (saisie.compareTo("o")==0){
					poursuite = true;
				}else{
					poursuite = false;
				}
			}

		}
	}

	static public double CalculExo10(int tbl[]) throws Exception {
		int i1 = 0, i2 = 0;

		int nb_calcul_réussis = 0;
		int nb_division_zero = 0;
		int nb_indice_hors_limite = 0;
		double moyenne_calcul = 0.0;

		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			i1 = rand.nextInt(11);
			i2 = rand.nextInt(11);
			//System.out.println("i1= " + i1);
			//System.out.println("i2= " + i2);
			try {
				//System.out.println("tbl[i1]= " + tbl[i1]);
				//System.out.println("tbl[i2]= " + tbl[i2]);
				//System.out.println("tbl[i1]/tbl[i2]= " + tbl[i1] / tbl[i2]);
				moyenne_calcul +=  tbl[i1] / tbl[i2];
				nb_calcul_réussis++;
			} catch (ArithmeticException e) {
				// traitement de l'erreur de division par zéro
				System.out.println("DIVISION PAR ZERO : tbl[i1] = " + tbl[i1] + " tbl[i2] = " + tbl[i2]); 
				nb_division_zero++;

			} catch (ArrayIndexOutOfBoundsException e) {
				// traitement de l'exception indice hors limites
				System.out.println("INDICE HORS LIMITE : i1 = " + i1 + " i2 = " + i2);
				nb_indice_hors_limite++;
			} catch (Exception e) {
				// traitement de l'exception générique
				System.out.println("Erreur générique");
				throw new Exception(e.getMessage());
			}
		}
		moyenne_calcul /= nb_calcul_réussis;
		System.out.println("\n\n" + nb_calcul_réussis + " calculs corrects");
		System.out.println(nb_division_zero + " DIVISION PAR ZERO");
		System.out.println(nb_indice_hors_limite + " INDICE HORS LIMITE");
		System.out.println("\nmoyenne=" + moyenne_calcul);
		if((nb_indice_hors_limite + nb_division_zero) != 0)
			throw new Exception(String.format("%f", moyenne_calcul));
		else
			return moyenne_calcul;

	}
	
	public static void td1_exo11() {
		// Exo 11
		// constantes 
		final int TAILLETABLEAU = 10;
		// pour le tirage aléatoire
		final int BORNEINF = -4;
		final int TAILLEINTERVAL = 12;

		// création/remplissage du tableau
		int[] tab = new int[TAILLETABLEAU];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int) (Math.random() * (TAILLEINTERVAL + 1)) + BORNEINF;
			// random -> [0;1[ -> [0;1[ * TAILLEINTERVAL+1 -> [0;TAILLEINTERVAL]
		}
		// affichage
		System.out.println(Arrays.toString(tab));
		
		boolean poursuite = true;
		double resultat = 0.0;
		while(poursuite){
			try {
				resultat = CalculExo11(tab);
				System.out.printf("moyenne = %1$.3f", resultat);
				poursuite = false;
			} catch (MonException e) {
				// traitement de l'exception perso
				System.out.println("\n\n" + e.nb_reussi + " calculs corrects");
				System.out.println(e.erreur_div_zero + " DIVISION PAR ZERO");
				System.out.println((10 - e.nb_reussi -e.erreur_div_zero)+ " INDICE HORS LIMITE");
				System.out.println("\nmoyenne=" + e.moy);
				poursuite = DemandePoursuite();
				
			}
			catch (Exception e) {
				// traitement de l'exception perso
				System.out.println("\nException inattendue : demande poursuite");
				poursuite = DemandePoursuite();
			}
		}
	}
	
	static boolean DemandePoursuite(){
		String saisie;
		do{
			System.out.println("Voulez-vous recommencer ? (o/n)" );
			saisie = Clavier.lireString();
		}while((saisie.charAt(0) != 'o') && (saisie.charAt(0) != 'n'));
	
		if (saisie.compareTo("o")==0){
			return true;
		}else{
			return false;
		}
	}

	static public double CalculExo11(int tbl[]) throws Exception {
		int i1 = 0, i2 = 0;

		int nb_calcul_réussis = 0;
		int nb_division_zero = 0;
		int nb_indice_hors_limite = 0;
		double moyenne_calcul = 0.0;

		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			i1 = rand.nextInt(11);
			i2 = rand.nextInt(11);
			//System.out.println("i1= " + i1);
			//System.out.println("i2= " + i2);
			try {
				//System.out.println("tbl[i1]= " + tbl[i1]);
				//System.out.println("tbl[i2]= " + tbl[i2]);
				//System.out.println("tbl[i1]/tbl[i2]= " + tbl[i1] / tbl[i2]);
				moyenne_calcul +=  tbl[i1] / tbl[i2];
				nb_calcul_réussis++;
			} catch (ArithmeticException e) {
				// traitement de l'erreur de division par zéro
				System.out.println("DIVISION PAR ZERO : tbl[i1] = " + tbl[i1] + " tbl[i2] = " + tbl[i2]); 
				nb_division_zero++;

			} catch (ArrayIndexOutOfBoundsException e) {
				// traitement de l'exception indice hors limites
				System.out.println("INDICE HORS LIMITE : i1 = " + i1 + " i2 = " + i2);
				nb_indice_hors_limite++;
			} catch (Exception e) {
				// traitement de l'exception générique
				System.out.println("Erreur générique");
				throw new Exception(e.getMessage());
			}
		}
		moyenne_calcul /= nb_calcul_réussis;
		if((nb_indice_hors_limite + nb_division_zero) != 0)
			throw new MonException(nb_calcul_réussis, nb_division_zero + nb_indice_hors_limite, moyenne_calcul,"Exception générée car un calcul c'est mal passé");
		else
			return moyenne_calcul;

	}
	
	public static void main(String[] args) {
		td1_exo9();
	}

}

class MonException extends Exception {

	private static final long serialVersionUID = 1L;
	public int nb_reussi;
	public int erreur_div_zero;
	public double moy;
	public String s;
	
	public MonException(int val1, int val2, double val3, String s) {
		super(s);
		this.nb_reussi = val1;
		this.erreur_div_zero = val2;
		this.moy = val3;
		this.s = s;
	}
	

}
