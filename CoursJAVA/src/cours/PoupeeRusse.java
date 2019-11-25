package cours;

public class PoupeeRusse {
protected int taille;	// 0.25
protected boolean estOuvert;  //0.25
protected PoupeeRusse poupeeContenant; //0.25
protected PoupeeRusse poupeeContenue;  //0.25

public PoupeeRusse(int taille) {    //0.25 jdoc
	this.taille = taille;           //0.25
	this.estOuvert = true;          //0.25
	this.poupeeContenant = null;    //0.25
	this.poupeeContenue = null;
}

public int getTaille() {
	return taille;
}
public boolean EstOuvert() {
	return estOuvert;
}
public PoupeeRusse getPoupeeContenant() {
	return poupeeContenant;
}
public PoupeeRusse getPoupeeContenue() {
	return poupeeContenue;
}
public void setTaille(int taille) {
	this.taille = taille;
}
public void Fermer() {
	this.estOuvert = false;
}
public void Ouvrir() {
	this.estOuvert = true;
}
public void setPoupeeContenant(PoupeeRusse poupeeContenant) {
	this.poupeeContenant = poupeeContenant;
}
public void setPoupeeContenue(PoupeeRusse poupeeContenue) {
	this.poupeeContenue = poupeeContenue;
}

	/* m�thode Ouvrir() pour passer l'attribut � vrai    0.25
	 * il faut d'abord v�rifier qu'elle n'est pas � l'int�rieur d'une autre poup�e, sinon on ne fait rien
	 * pas d'exception retourn�e
	 */
	public void ouvrir(){    //0.25
		// v�rif contenant, on suppose qu'il vaut null si il n'est pas contenu
		if (poupeeContenant == null){  // 0.25
			estOuvert = true;       //0.25
		}
	}
	
	/*
	 * methode placeDans
	 *   param p la poup�e � placer � l'int�rieur de la poup�e courante
	 *   conditions � v�rifier : pas de contenant de la poup�e courante + elle est ouverte
	 *                           p ne doit pas �tre d�j� contenue + ferm�e + taille sup�rieur que la courante
	 *   exception si p est null ou si les conditions ne sont pas remplies   //0.25
	 */
	public void placerDans(PoupeeRusse p) throws Exception{

			// v�rif conditions   0.25
			if(poupeeContenant == null && p.getPoupeeContenue() == null 
			   && estOuvert == false && p.estOuvert == true && p.getTaille()>taille){
				poupeeContenant = p;   //0.25
				p.setPoupeeContenue(this);  //0.25
			}
			// sinon traitement des probl�mes par exception
			else{    //0.5   0.25 exception / 0.25 test
				if (poupeeContenant != null)
					throw new Exception("la poup�e ne doit pas �tre contenue");
				if (p.getPoupeeContenue() != null)
					throw new Exception("la poup�e cible doit �tre vide");
				if (estOuvert != false)
					throw new Exception("la poup�e doit �tre ferm�e");
				if (p.EstOuvert() != true)
					throw new Exception("la poup�e cible doit �tre ouverte");
				if(p.getTaille() <= taille)
					throw new Exception("la poup�e cible doit �tre plus grande que la poup�e � placer");
			}
	}
	/*
	 * methode sortirDe
	 *   param p la poup�e d'o� l'on sort la poup�e courante
	 *   conditions � v�rifier : la poup�e courante est dans p
	 *                           p doit �tre ouverte
	 *   exception si p est null ou si les conditions ne sont pas remplies
	 */
	void sortirDe(PoupeeRusse p) throws Exception{
		// v�rif conditions
		if(p.estOuvert == true && p.getPoupeeContenue() == this && poupeeContenant == p){
			poupeeContenant = null; 
			p.setPoupeeContenue(null);
		}
		// sinon traitement des probl�mes par exception
		else{
			if (p.EstOuvert() != true)
				throw new Exception("la poup�e contenante doit �tre ouverte");
			if(p.getPoupeeContenue() != this || poupeeContenant != p)
				throw new Exception("la poup�e n'est pas dans la poup�e cible");
		}
} 
	
	public static void main(String[] args) {
		PoupeeRusse p1 = new PoupeeRusse(1);
		p1.Fermer();
		PoupeeRusse p2 = new PoupeeRusse(2);
		
		try {
			p1.placerDans(p2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
