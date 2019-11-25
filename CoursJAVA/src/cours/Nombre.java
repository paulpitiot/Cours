package cours;

public class Nombre {
	/**
	 * renvoie le plus grand diviseur commun à a et b, 
	 * pgcd(0,0) vaut 0 et non infinity
	 * @param a un nombre entier
	 * @param b un nombre entier
	 * @return  le plus grand diviseur commun à a et b
	*/
	public static int pgcd(int a,int b){
		return (0 == a * b) ? Math.abs(a+b) : pgcd(b%a,a);
	}
	
	/**
	 * renvoie le plus grand diviseur commun à a et b, 
	 * pgcd(0,0) vaut 0 et non infinity
	 * @param a un nombre entier
	 * @param b un nombre entier
	 * @return  le plus grand diviseur commun à a et b
	*/
	public static int pgcdBoucle(int a,int b){
		while(a*b !=0){
			int c = a;a=b;b=c; //swap(a,b) inverse a et b
			a %= b;
		}
		return Math.abs(a+b) ;
	}
	
	
	/**
	 * Convertit tous nombres positifs  < 1024  en chaine binaire,
	 * @param dec le nombre à convertir en binaire < 1024
	 * @return le binaire équivalent à dec en chaine
	 * @throws Exception 
	 */
	public static Long decimalToBinaire(long dec) throws Exception{
		if(dec>1023 || dec < 0){
			//utiliser des chaines ou la classe bigInteger si besoins de plus grand
			throw new Exception("nombre trop grand ou négatif");
		}
		return dec > 0 ?  10*decimalToBinaire(dec/2)+dec%2  : 0;
	}

	/**
	 * Convertit tous nombres positifs  < 1024 en chaine binaire
	 * @param dec le nombre à convertir en binaire < 1024
	 * @return le binaire équivalent à dec en chaine
	 * @throws Exception 
	 */
	public static Long decimalToBinaireBoucle(long dec) throws Exception{
		if(dec>1023 || dec < 0){
			//utiliser des chaines ou la classe bigInteger si besoins de plus grand
			throw new Exception("nombre trop grand ou négatif");
		}
		Long res = 0l;
		for (int i = 1 ;dec > 0; i*=10){
			res += i * (dec%2);
			dec /= 2;
		}
		return res;
	}
	/**
	 * Le programme principal est un menu proposant le choix entre 2 programmes de manière récursive ou non
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		long res=0l;
		int p1,p2; //choix parametre utilisateur
		System.out.println("choisir un programme"+
			"\n 1 et 2 le pgcd (1 recursive 2 boucle)"+
			"\n 3 et 4 conversion en binaire d'un decimale(3 recursive 4 boucle)"+
			"\n Autre pour quitter");
		int choice = Clavier.lireInt();
		if(choice < 1 || choice > 4){//0 et moins
			System.out.println("programme terminé");
			return;
		}
		if(choice < 3){//1 et 2
			System.out.println("Entrer les 2 nombres dont vous souhaitez le pgcd "
					+ "tapez entrer àprès chaque nombre");
			p1=Clavier.lireInt();
			p2=Clavier.lireInt();
			switch(choice){
				case 1:
					res = pgcd(p1,p2);
				case 2:
					res = pgcdBoucle(p1,p2);
			}		
		}else{//3 et 4
			System.out.println("Entrer un nombre < 1024 et positif à convertir en binaire puis entrer");
			p1=Clavier.lireInt();
			while(p1>1023){
				System.out.println("j'ai dis moins de 1024 sinon utiliser la classe bigInteger");
				p1=Clavier.lireInt();
			}
			switch(choice){
				case 3:
					res = decimalToBinaire(p1);
				case 4:
					res = decimalToBinaireBoucle(p1);
			}			
		}
		System.out.println("Le résultat est "+res);
		main(args);
	}
	
	
}


