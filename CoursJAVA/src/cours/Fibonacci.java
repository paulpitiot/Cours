package cours;

public class Fibonacci {
		// variable globale à la classe permettant de compter le nombre d'appel
		private static long compteurAppel = 0;

		public static void resetCompteurAppel() {
			compteurAppel = 0;
		}
		
		public static long getCompteurAppel() {
			return compteurAppel;
		}
		
		/**
		 * calcul la suite de Fibonacci au rang n 
		 * @variables : n0, n1, n2  variables utilisées pour stocker les valeurs intermédiaires de calcul
		 * @param : n (entier) nombre dont on veut connaitre la valeur dans la suite de fibo
		 * @return valeur du rang n
		 */
		public static int fibonacciIteratif(int n) {
			int n0 = 0, n1 = 1, n2 = 1, nCourant = 1;
			compteurAppel++;
			if (n > 1) {
				while(nCourant < n) {
					n2 = n0 + n1; 
					n0 = n1; 
					n1 = n2;
					nCourant++; 
				}
			}
			return n2;
		}
		
		/**
		 * calcul la suite de Fibonacci au rang n 
		 * @param : n (entier) nombre dont on veut connaitre la valeur dans la suite de fibo
		 * @return valeur du rang n
		 */
		public static int fibonacciRecurssif(int n) {
			
			compteurAppel++;
			if (n >= 2){
				return fibonacciRecurssif(n-1) + fibonacciRecurssif(n-2);
			} else {
				return n;
			}
		}
		
	



	
	
}
