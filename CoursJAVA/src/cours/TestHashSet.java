package cours;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class TestHashSet {

	public static void main(String[] args) {
		final int NBELEMENTS = 50;
		final int LOWERBOUND = 10;
		final int UPPERBOUND = 64;
		
		HashSet<Integer> collection = new HashSet<Integer>(NBELEMENTS);
		for(int i = 0 ; i < NBELEMENTS ; i++){
			// test d'un autre générateur de nombre aléatoire ici sécurisé en multithread
			collection.add(ThreadLocalRandom.current().nextInt(LOWERBOUND,UPPERBOUND+1));
		}
		// affichage taille et valeurs
		
		System.out.println("Taille de la collection : " + collection.size() );
		
		Iterator <Integer> it = collection.iterator () ;
	    while (it.hasNext()){
	    	System.out.print(it.next() + " ");
	    }

		
	}

}
