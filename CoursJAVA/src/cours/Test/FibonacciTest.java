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
		
		// N doit �tre strictement sup�rieur � 0
		do{
			System.out.println("N doit �tre entre 0 et 46");
			System.out.print("Calcul de la suite de Fibonacci de N = ");
			n = Clavier.lireInt();
		} while(n < 0  ) ;
		
		Fibonacci.resetCompteurAppel();
		
		System.out.println("fibonacci it�ratif : " + Fibonacci.fibonacciIteratif(n) + " est la valeur au rang N : "+ n);
		System.out.println("fibonacci it�ratif appel�e " + Fibonacci.getCompteurAppel() + " fois");
		
		Fibonacci.resetCompteurAppel();
		
		System.out.println("fibonacci r�curssif : " + Fibonacci.fibonacciRecurssif(n) + " est la valeur au rang N : "+ n);
		System.out.println("fibonacci r�curssif appel�e " + Fibonacci.getCompteurAppel() + " fois");

	}
	
	
	@Test
	public void testDifferentesValeursN() {
		// pour le terme 12 la valeur attendue est 144 
		assertTrue("le r�sultat n'est pas le bon fibo(12) = 144", Fibonacci.fibonacciIteratif(12) == 144);
		assertTrue("le r�sultat n'est pas le bon fibo(12) = 144", Fibonacci.fibonacciRecurssif(12) == 144);
		// pour le terme 1 la valeur attendue est 1
		assertTrue("le r�sultat n'est pas le bon fibo(0) = 1", Fibonacci.fibonacciRecurssif(1) == 1);
		// pour le terme 0 la valeur attendue est 1
		assertTrue("le r�sultat n'est pas le bon fibo(0) = 1", Fibonacci.fibonacciRecurssif(0) == 1);
		// pour une valeur n�gatif la valeur attendue est 1
		assertTrue("echec test pour une valeur n�gative", Fibonacci.fibonacciRecurssif(0) == 1);
		
		assertTrue("le r�sultat n'est pas le bon fibo(12) = 144", Fibonacci.fibonacciIteratif(12) == 144);
		// pour le terme 1 la valeur attendue est 1
		assertTrue("le r�sultat n'est pas le bon fibo(0) = 1", Fibonacci.fibonacciIteratif(1) == 1);
		// pour le terme 0 la valeur attendue est 1
		assertTrue("le r�sultat n'est pas le bon fibo(0) = 1", Fibonacci.fibonacciIteratif(0) == 1);
		// pour une valeur n�gatif la valeur attendue est 1
		assertTrue("echec test pour une valeur n�gative", Fibonacci.fibonacciIteratif(0) == 1);
		
		

	}
	
}
