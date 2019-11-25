package cours;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestTriCollection {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<Object> strList = new ArrayList<>();
		ArrayList<Object> al = new ArrayList<>();
		ArrayList<Integer> arl = new ArrayList<Integer>();
		List<Integer> li = new ArrayList<Integer>();
		
		strList.add(new Integer(2) );
		strList.add(new Double(2.0) );
		for (Object obj : strList) {
			System.out.println(obj);
		}
		
		al.add(new Integer(3) );
		al.add(new Double(3.0) );
		
		
		li.add(new Integer(4) );
		li.add(new Integer(5) );
		

		for (Object obj : al) {
			System.out.println(obj);
		}
		
		for (Integer integer : li) {
			System.out.println(integer);
		}
		
		List<Score> listeScore = new LinkedList<Score>();
		Score sc1 = new Score("GEORGES", 0, 67);
		listeScore.add(sc1);
		Score sc2 = new Score("MARCEL", 0, 67);
		listeScore.add(sc2);
		Score sc3 = new Score("RENEE", 0, 155);
		listeScore.add(sc3);
		Score sc4 = new Score("GEORGES", 2, 84);
		listeScore.add(sc4);
		Score sc5 = new Score("LUCIEN", 15, 220);
		listeScore.add(sc5);

		Collections.sort(listeScore);

		for (Score sc : listeScore) {
			sc.affiche();
		}

	}

}
