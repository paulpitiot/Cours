package cours;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LecteurFichier {

	@SuppressWarnings("unused")
	static public void LectureFichier(File texte) throws Exception {
		if (!texte.exists()) {
			throw new Exception("Fichier ou r�pertoire inexistant");
		} else {
			System.out.println("R�pertoire = " + texte.getParent());
			System.out.println("Le fichier " + texte.getName() + " contient " + texte.length() + " octets");

			// variables de comptage
			int nbCarac = 0, nbCaracNum = 0, nbCaracAlpha = 0, nbS�parateurs = 0, nbCaracPerdu = 0;

			try (BufferedReader br = new BufferedReader(new FileReader(texte))) {
				int caract = br.read(); // on est pas s�r qu'il y ai un
										// caract�re! -> while()
				while (caract != -1) {
				//    System.out.print( (char)caract + " "); // pour l'affichage
					nbCarac++;
					if (Character.isDigit(caract))
						nbCaracNum++;
					else {
						if (Character.isAlphabetic(caract))
							nbCaracAlpha++;
						else {
							if (Character.isWhitespace(caract))
								nbS�parateurs++;
						}
					}
					nbCaracPerdu = nbCarac - nbCaracNum - nbCaracAlpha - nbS�parateurs;
					caract = br.read();
				}
			} catch (FileNotFoundException e) { // normalement le fichier existe
												// puisqu'on l'a v�rifi�
				System.out.println(e.getMessage());
			} catch (IOException e) { //
				System.out.println(e.getMessage());
			}
			System.out.println("nbCaract : " + nbCarac);
			System.out.println("nbCaracNum : " + nbCaracNum);
			System.out.println("nbCaracAlpha : " + nbCaracAlpha);
			System.out.println("nbS�parateurs : " + nbS�parateurs);
			System.out.format("%.2f%% de num�riques", nbCaracNum / ((double) nbCarac) * 100);

		}

	}

	static public void LectureFichierExo2(File texte) throws Exception {
		if (!texte.exists()) {
			throw new Exception("Fichier ou r�pertoire inexistant");
		} else {
			System.out.println("R�pertoire = " + texte.getParent());
			System.out.println("Le fichier " + texte.getName() + " contient " + texte.length() + " octets");

			// variables de comptage
			int nbLignes = 0;

			try (BufferedReader br = new BufferedReader(new FileReader(texte))) {
				String ligneLue = br.readLine(); // on est pas s�r qu'il y ai un
													// caract�re! -> while()
				while (ligneLue != null) {
					System.out.println("Lu : " + ligneLue + " (" + ligneLue.length() + ")");
					nbLignes++;
					ligneLue = br.readLine();
				}
			} catch (FileNotFoundException e) { // normalement le fichier existe
												// puisqu'on l'a v�rifi�
				System.out.println(e.getMessage());
			} catch (IOException e) { //
				System.out.println(e.getMessage());
			}
			System.out.println("nbLignes : " + nbLignes);

		}

	}

	static public void LectureFichierExo3(File texte) throws Exception {
		if (!texte.exists()) {
			throw new Exception("Fichier ou r�pertoire inexistant");
		} else {
			System.out.println("R�pertoire = " + texte.getParent());
			System.out.println("Le fichier " + texte.getName() + " contient " + texte.length() + " octets");

			// variables de comptage + tableaux
			int nbScores = 0;

			try (BufferedReader br = new BufferedReader(new FileReader(texte))) {
				String ligneLue = br.readLine();
				while (ligneLue != null) {
					// System.out.println( "Lu : " + ligneLue + " (" +
					// ligneLue.length() + ")");
					if (ligneLue.trim().startsWith("<p>") == true) {
						nbScores++;
					}
					ligneLue = br.readLine();
				}

			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("nbScores : " + nbScores);

			// tableaux � remplir
			// PS on aurait pu faire qu'un seul parcours avec un liste
			// (ArrayList par exemple)
			String[] TabPseudo = new String[nbScores];
			String[] TabScore = new String[nbScores];
			String[] TabTemps = new String[nbScores];
			int indice_courant = 0;

			try (BufferedReader br = new BufferedReader(new FileReader(texte))) {
				String ligneLue = br.readLine();
				while (ligneLue != null) {
					if (ligneLue.trim().startsWith("<p>") == true) {
						String sub = ligneLue.substring(30);
						String[] boutDeLignesLues = sub.split(".=.|</b>.en.|<small><small>....|.</small></small>|</p>");
						/*
						 * for(String s : boutDeLignesLues){
						 * System.out.println(s); }
						 */
						TabPseudo[indice_courant] = boutDeLignesLues[0];
						TabScore[indice_courant] = boutDeLignesLues[1];
						TabTemps[indice_courant] = boutDeLignesLues[2];
						indice_courant++;
					}
					ligneLue = br.readLine();
				}

			} catch (FileNotFoundException e) { // normalement le fichier existe
												// puisqu'on l'a v�rifi�
				System.out.println(e.getMessage());
			} catch (IOException e) { //
				System.out.println(e.getMessage());
			}
			for (int i = 0; i < nbScores; ++i) {
				System.out.println("Pseudo=" + TabPseudo[i] + "\tScore=" + TabScore[i] + "\tTemps=" + TabTemps[i]);
			}

		}

	}

	static public void LectureFichierExo4(File texte) throws Exception {
		if (!texte.exists()) {
			throw new Exception("Fichier ou r�pertoire inexistant");
		} else {
			System.out.println("R�pertoire = " + texte.getParent());
			System.out.println("Le fichier " + texte.getName() + " contient " + texte.length() + " octets");

			// variables de comptage + tableaux
			int nbScores = 0;

			try (BufferedReader br = new BufferedReader(new FileReader(texte))) {
				String ligneLue = br.readLine();
				while (ligneLue != null) {
					// System.out.println( "Lu : " + ligneLue + " (" +
					// ligneLue.length() + ")");
					if (ligneLue.trim().startsWith("<p>") == true) {
						nbScores++;
					}
					ligneLue = br.readLine();
				}

			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("nbScores : " + nbScores);

			// tableaux � remplir
			// PS on aurait pu faire qu'un seul parcours avec un liste
			// (ArrayList par exemple)
			TabPseudo = new String[nbScores];
			TabScore = new String[nbScores];
			TabTemps = new String[nbScores];
			int indice_courant = 0;

			try (BufferedReader br = new BufferedReader(new FileReader(texte))) {
				String ligneLue = br.readLine();
				while (ligneLue != null) {
					if (ligneLue.trim().startsWith("<p>") == true) {
						String sub = ligneLue.substring(30);
						String[] boutDeLignesLues = sub.split(".=.|</b>.en.|<small><small>....|.</small></small>|</p>");
						/*
						 * for(String s : boutDeLignesLues){
						 * System.out.println(s); }
						 */
						TabPseudo[indice_courant] = boutDeLignesLues[0].toUpperCase();
						TabScore[indice_courant] = boutDeLignesLues[1];
						TabTemps[indice_courant] = boutDeLignesLues[2];
						indice_courant++;
					}
					ligneLue = br.readLine();
				}

			} catch (FileNotFoundException e) { // normalement le fichier existe
												// puisqu'on l'a v�rifi�
				System.out.println(e.getMessage());
			} catch (IOException e) { //
				System.out.println(e.getMessage());
			}

			String nomRecherch�;
			do {
				System.out.println("Saisir le nom de la personne recherch�e (F ou Fin pour arr�ter):");
				nomRecherch� = Clavier.lireString();
				if (nomRecherch�.compareTo("Fin") == 0 || nomRecherch�.compareTo("F") == 0)
					break;
				nomRecherch� = nomRecherch�.toUpperCase();
				int rechercheIndicePersonne = RechercheIndiceTabPseudo(nomRecherch�);
				if (rechercheIndicePersonne != -1) {
					System.out.println("Personne recherch�e :");
					System.out.println("Pseudo=" + TabPseudo[rechercheIndicePersonne] + "\tScore="
							+ TabScore[rechercheIndicePersonne] + "\tTemps=" + TabTemps[rechercheIndicePersonne]);
				} else {
					System.out.println("Personne recherch�e non inscrite");
				}
			} while (true);
		}

	}

	// pour l'exercie 4

	static String[] TabPseudo;
	static String[] TabScore;
	static String[] TabTemps;

	/*
	 * fonction de recherche dans le tableau des pseudo parcours le tableau
	 * TabPseudo static
	 * 
	 * @param nomRecherch� de type String
	 * 
	 * @return -1 si la personne recherch�e n'existe pas sinon son indice
	 */
	static int RechercheIndiceTabPseudo(String nomRecherch�) {
		for (int i = 0; i < TabPseudo.length; i++) {
			if (nomRecherch�.compareTo(TabPseudo[i]) == 0)
				return i;
		}
		return -1;
	}
	
	 static public String getStringFromFile( String path ) throws Exception {
			/*----------NE MODIFIEZ PAS LE CODE AU DESSUS DE CETTE LIGNE, IL SERA REINITIALISE LORS DE l'EXECUTION----------*/
		 String total ="";
	        BufferedReader br = new BufferedReader(new FileReader(path));
				int ligneLue = br.read(); 
				total += (char)ligneLue;
				while (ligneLue != -1) {
					ligneLue = br.read();
					total+= " " + (char) ligneLue ;
				}
			System.out.println("++++++++++++++++++++");	
			System.out.println(total);
			System.out.println("+++++++++++++++++++++");
			return total;
			/*----------NE MODIFIEZ PAS LE CODE EN DESSOUS DE CETTE LIGNE, IL SERA REINITIALISE LORS DE l'EXECUTION----------*/
	    }

	public static void main(String[] args) {
		File rep = new File(System.getProperty("user.dir"), "data\\scores.html");
		String path = System.getProperty("user.dir")+ "\\data\\scores.html";
		try {
			getStringFromFile( path );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
