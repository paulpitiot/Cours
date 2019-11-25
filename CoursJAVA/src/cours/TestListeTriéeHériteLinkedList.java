package cours;

import java.util.*;

public class TestListeTriéeHériteLinkedList {
	public static void main(String args[]) {
		ListeTriee<String> liste = new ListeTriee<String>();
		liste.ajoute("c");
		liste.affiche();
		liste.ajoute("b");
		liste.affiche();
		liste.ajoute("f");
		liste.affiche();
		liste.ajoute("e");
		liste.affiche();
	}
}

class ListeTriee<E extends Comparable <E>> extends LinkedList<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListeTriee() {
	}

	public void ajoute(E e) {
		ListIterator<E> it = this.listIterator();
		boolean trouve = false;
		while ((it.hasNext()) && !trouve) {
			if (it.next().compareTo(e) > 0)
				trouve = true;
		}
		if (trouve)
			it.previous(); // ici, il y obligatoirement un precedent
		it.add(e);
	}

	public void affiche() {
		for (E e : this)
			System.out.print(e + " ");
		System.out.println();
	}

}