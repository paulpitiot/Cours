
package cours;


import java.util.Scanner;

public class Palindrome {

	/**
	 * Programme permettant de déterminer si une chaîne de caractères saisie est un palindrome.
	 * @author a.viala/b.pemeja
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//VARIABLES
		char[] chaine;
		String mot;
		int nbCaract, debutMot, finMot;
		
		//INITIALISATION
		nbCaract = debutMot = finMot = 0;		
		System.out.println("Entrez un mot svp : ");
		Scanner sc = new Scanner(System.in);
		mot = sc.next();
		chaine = mot.toCharArray();
		nbCaract = mot.length();
		finMot = nbCaract-1;
		
		// Controle du mot 
			while(chaine[debutMot] == chaine[finMot] && debutMot <= finMot )
			{
				debutMot++;
				finMot--;
			}	
		// Le mot n'est pas un palindrome
		if(chaine[debutMot] != chaine[finMot])
		{
			System.out.println("Le mot " +mot+ " n'est pas un palindrome");
		}
		// Le mot est un palindrome
		else
		{
			System.out.println("Le mot " +mot+ " est un palindrome");
		}
		
		sc.close();
	}
}
