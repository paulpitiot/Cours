package tda_red�finition;

abstract class ListeAbstraite<E> implements Liste<E> {
	final E �l�mentDeTete() {
		return i�me(1);
	}

	final E �l�mentDeQueue() {
		return i�me(longueur());
	}

	final void ajouterEnTete(E e) {
		ajouter(1, e);
	}

	final void ajouterEnQueue(E e) {
		ajouter(longueur() + 1, e);
	}

	final void supprimerEnTete() {
		supprimer(1);
	}

	final void supprimerEnQueue() {
		supprimer(longueur());
	}

}
