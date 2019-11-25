package cours;


import java.util.Arrays;

import org.junit.Test;

public class CompareTabTest {

	@Test
	public void testArraysEquals() {
		Integer[] tab1 = { 1, 2, 3, 4, 5 };
		Integer[] tab2 = { 1, 2, 3, 4, 5 };
		Double[] tab3 = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		Integer[] tab4 = { 1, 2, 3, 4 };

		SimpleLogger.logInfo("Comparaison tab1 / tab2 : " + CompareTab.arraysEquals(tab1, tab2));
		SimpleLogger.logInfo("Comparaison tab1 / tab3 : " + CompareTab.arraysEquals(tab1, tab3));
		SimpleLogger.logInfo("Comparaison tab1 / tab4 : " + CompareTab.arraysEquals(tab1, tab4));

		Eleve el1 = new Eleve("Paul");
		Eleve el2 = new Eleve("Luc");
		Eleve el3 = new Eleve("Paul");

		Eleve[] tabEleve1 = { el1, el2 };
		Eleve[] tabEleve2 = { el1, el2 };
		Eleve[] tabEleve3 = { el3, el2 };

		SimpleLogger.logInfo("tabEleve1 : " + Arrays.toString(tabEleve1));
		SimpleLogger.logInfo("tabEleve2 : " + Arrays.toString(tabEleve2));
		SimpleLogger.logInfo("tabEleve3 : " + Arrays.toString(tabEleve3));

		SimpleLogger.logInfo("Comparaison tabEleve1 / tabEleve2 : " + CompareTab.arraysEquals(tabEleve1, tabEleve2));
		// true car il compare les référence9s des objects mais pas le contenu!
		SimpleLogger.logInfo("Comparaison tabEleve1 / tabEleve3 : " + CompareTab.arraysEquals(tabEleve1, tabEleve3));
		// false car la référence de el1 != référence de el3 alors que leur
		// contenu est identique!!

		// Pour que cela compare le contenu, il faut redéfinir la méthode equals
		// pour qu'elle compare le contenu

		EleveEquals ele1 = new EleveEquals("Paul");
		EleveEquals ele2 = new EleveEquals("Luc");
		EleveEquals ele3 = new EleveEquals("Paul");

		EleveEquals[] tabEleveEquals1 = { ele1, ele2 };
		EleveEquals[] tabEleveEquals2 = { ele1, ele2 };
		EleveEquals[] tabEleveEquals3 = { ele3, ele2 };

		SimpleLogger.logInfo("tabElèveEquals1 : " + Arrays.toString(tabEleveEquals1));
		SimpleLogger.logInfo("tabElèveEquals2 : " + Arrays.toString(tabEleveEquals2));
		SimpleLogger.logInfo("tabElèveEquals3 : " + Arrays.toString(tabEleveEquals3));

		SimpleLogger.logInfo("Comparaison tabElèveEquals1 / tabElèveEquals2 : "
				+ CompareTab.arraysEquals(tabEleveEquals1, tabEleveEquals2));
		// true car il compare les références des objects mais pas le contenu!
		SimpleLogger.logInfo("Comparaison tabElèveEquals1 / tabElèveEquals3 : "
				+ CompareTab.arraysEquals(tabEleveEquals1, tabEleveEquals3));
	}

}
