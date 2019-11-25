package tda_redéfinition;

abstract class ListeAbstraite<E> implements Liste<E> {
	final E élémentDeTete() {
		return ième(1);
	}

	final E élémentDeQueue() {
		return ième(longueur());
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
