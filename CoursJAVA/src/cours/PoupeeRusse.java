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

	/* méthode Ouvrir() pour passer l'attribut à vrai    0.25
	 * il faut d'abord vérifier qu'elle n'est pas à l'intérieur d'une autre poupée, sinon on ne fait rien
	 * pas d'exception retournée
	 */
	public void ouvrir(){    //0.25
		// vérif contenant, on suppose qu'il vaut null si il n'est pas contenu
		if (poupeeContenant == null){  // 0.25
			estOuvert = true;       //0.25
		}
	}
	
	/*
	 * methode placeDans
	 *   param p la poupée à placer à l'intérieur de la poupée courante
	 *   conditions à vérifier : pas de contenant de la poupée courante + elle est ouverte
	 *                           p ne doit pas être déjà contenue + fermée + taille supérieur que la courante
	 *   exception si p est null ou si les conditions ne sont pas remplies   //0.25
	 */
	public void placerDans(PoupeeRusse p) throws Exception{

			// vérif conditions   0.25
			if(poupeeContenant == null && p.getPoupeeContenue() == null 
			   && estOuvert == false && p.estOuvert == true && p.getTaille()>taille){
				poupeeContenant = p;   //0.25
				p.setPoupeeContenue(this);  //0.25
			}
			// sinon traitement des problèmes par exception
			else{    //0.5   0.25 exception / 0.25 test
				if (poupeeContenant != null)
					throw new Exception("la poupée ne doit pas être contenue");
				if (p.getPoupeeContenue() != null)
					throw new Exception("la poupée cible doit être vide");
				if (estOuvert != false)
					throw new Exception("la poupée doit être fermée");
				if (p.EstOuvert() != true)
					throw new Exception("la poupée cible doit être ouverte");
				if(p.getTaille() <= taille)
					throw new Exception("la poupée cible doit être plus grande que la poupée à placer");
			}
	}
	/*
	 * methode sortirDe
	 *   param p la poupée d'où l'on sort la poupée courante
	 *   conditions à vérifier : la poupée courante est dans p
	 *                           p doit être ouverte
	 *   exception si p est null ou si les conditions ne sont pas remplies
	 */
	void sortirDe(PoupeeRusse p) throws Exception{
		// vérif conditions
		if(p.estOuvert == true && p.getPoupeeContenue() == this && poupeeContenant == p){
			poupeeContenant = null; 
			p.setPoupeeContenue(null);
		}
		// sinon traitement des problèmes par exception
		else{
			if (p.EstOuvert() != true)
				throw new Exception("la poupée contenante doit être ouverte");
			if(p.getPoupeeContenue() != this || poupeeContenant != p)
				throw new Exception("la poupée n'est pas dans la poupée cible");
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
