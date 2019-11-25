package cours;

import java.util.Arrays;

public class CompareTab {

	public static boolean arraysEquals(Object[] tab1, Object[] tab2) {
		if ((tab1.length == tab2.length) && tab1.length > 0) {
			if (tab1[0].getClass() == tab2[0].getClass()) {
				for (int i = 0; i < tab1.length; i++) {
					if (!tab1[i].equals(tab2[i])) {
						// attention la méthode equals doit être redéfinie pour
						// que cela marche
						// par exemple pour les classes d'équivalence (ex:
						// Integer) c'est déjà fait !
						// mais pour d'autres classes, il faut le faire
						return false;
					}
				}
				return true;
			}
		}

		return false;
	}

}

class Eleve {
	String nom;

	public Eleve(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}
}

class EleveEquals {
	private String nom;

	public EleveEquals(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EleveEquals other = (EleveEquals) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else {
			if (!nom.equals(other.nom))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nom;
	}

}
