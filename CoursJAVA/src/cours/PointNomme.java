package cours;

import java.util.logging.Level;

class PointNomme extends Couple<Integer> {
	private String nom;

	public PointNomme(Integer premier, Integer second, String nom) {
		super(premier, second);
		this.nom = nom;
	}

	@Override
	public void affiche() {
		SimpleLogger.log.log(Level.INFO, "nom = " + nom + " - ");
		super.affiche();
	}

}
