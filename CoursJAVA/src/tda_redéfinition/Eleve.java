package tda_redéfinition;


import java.util.Arrays;

public class Eleve implements Comparable<Eleve> {
	
	String nom;
	String prenom;
	Date naissance;
	char groupe;
	double moyenne;
	double [] moyenne_ue;
	public Eleve() {
		this.nom = null;
		this.prenom = null;
		this.naissance = null;
		this.groupe = 0;
		this.moyenne = 0;
		this.moyenne_ue = null;
	}
	
	public Eleve(String nom, String prenom, Date naissance, char groupe) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.groupe = groupe;
	}
	
	@Override
	public String toString() {
		return  nom + ", " + prenom + ", "
				+ naissance + ", groupe=" + groupe + ",moy=" + moyenne;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getNaissance() {
		return naissance;
	}
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}
	
	public char getGroupe() {
		return groupe;
	}
	public void setGroupe(char groupe) {
		this.groupe = groupe;
	}
	public double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}
	public double[] getMoyenne_ue() {
		return moyenne_ue;
	}
	public void setMoyenne_ue(double[] moyenne_ue) {
		this.moyenne_ue = moyenne_ue;
	}
	public void saisie(String nom, String prenom, int jour, int mois, int annee, char groupe) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance.setJour(jour); 
		this.naissance.setMois(mois);
		this.naissance.setAnnee(annee);
		this.groupe = groupe;
	}
	

	public static void main(String[] args) {
		Eleve [] promo = new Eleve[10];
		Eleve el1 = new Eleve("lettre", "elise", new Date(2,9,80), 'A');
		Eleve el2 = new Eleve("pitiot", "paul", new Date(2,9,82), 'B');
		Eleve el3 = new Eleve("thérèse", "marie", new Date(10,8,84), 'A');
		Eleve el4 = new Eleve("mouly", "xavier", new Date(5,10,79), 'B');
		//System.out.println(el1);
		promo[0] = el1;
		System.out.println(Arrays.toString(promo));
	}

	@Override
	public int compareTo(Eleve o) {
		if(o.moyenne > this.moyenne)
				return -1;
		if(o.moyenne == this.moyenne)
			return 0;
		return 1;
	}
	
}
