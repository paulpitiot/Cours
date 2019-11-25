package cours.Test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import cours.Clavier;
import cours.Fibonacci;

public class FibonacciTest {

	@Test //Ignore
	public void testManuel() {
		int n; 
		
		// N doit être strictement supérieur à 0
		do{
			System.out.println("N doit être entre 0 et 46");
			System.out.print("Calcul de la suite de Fibonacci de N = ");
			n = Clavier.lireInt();
		} while(n < 0  ) ;
		
		Fibonacci.resetCompteurAppel();
		
		System.out.println("fibonacci itératif : " + Fibonacci.fibonacciIteratif(n) + " est la valeur au rang N : "+ n);
		System.out.println("fibonacci itératif appelée " + Fibonacci.getCompteurAppel() + " fois");
		
		Fibonacci.resetCompteurAppel();
		
		System.out.println("fibonacci récurssif : " + Fibonacci.fibonacciRecurssif(n) + " est la valeur au rang N : "+ n);
		System.out.println("fibonacci récurssif appelée " + Fibonacci.getCompteurAppel() + " fois");

	}
	
	
	@Test
	public void testDifferentesValeursN() {
		// pour le terme 12 la valeur attendue est 144 
		assertTrue("le résultat n'est pas le bon fibo(12) = 144", Fibonacci.fibonacciIteratif(12) == 144);
		assertTrue("le résultat n'est pas le bon fibo(12) = 144", Fibonacci.fibonacciRecurssif(12) == 144);
		// pour le terme 1 la valeur attendue est 1
		assertTrue("le résultat n'est pas le bon fibo(0) = 1", Fibonacci.fibonacciRecurssif(1) == 1);
		// pour le terme 0 la valeur attendue est 1
		assertTrue("le résultat n'est pas le bon fibo(0) = 1", Fibonacci.fibonacciRecurssif(0) == 1);
		// pour une valeur négatif la valeur attendue est 1
		assertTrue("echec test pour une valeur négative", Fibonacci.fibonacciRecurssif(0) == 1);
		
		assertTrue("le résultat n'est pas le bon fibo(12) = 144", Fibonacci.fibonacciIteratif(12) == 144);
		// pour le terme 1 la valeur attendue est 1
		assertTrue("le résultat n'est pas le bon fibo(0) = 1", Fibonacci.fibonacciIteratif(1) == 1);
		// pour le terme 0 la valeur attendue est 1
		assertTrue("le résultat n'est pas le bon fibo(0) = 1", Fibonacci.fibonacciIteratif(0) == 1);
		// pour une valeur négatif la valeur attendue est 1
		assertTrue("echec test pour une valeur négative", Fibonacci.fibonacciIteratif(0) == 1);
		
		

	}
	
}
