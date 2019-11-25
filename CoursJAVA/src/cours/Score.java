package cours;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Score implements Comparable<Score>{
	String pseudo,date;
	int valeur, temps;
	
	public Score(String pseudo, int valeur, int temps) {
		super();
		this.pseudo = pseudo;
		this.date = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(new Date());
		this.valeur = valeur;
		this.temps = temps;
	}

	
	
	
	public void affiche(){
		System.out.format("%s = %d en %02d:%02d   (le %s)\n", pseudo, valeur, temps/60,temps%60,date);
	}

	
	
	
	
	@Override
	public int compareTo(Score o) {
		if (valeur < o.valeur ) return -1 ;
	    else {
	    	if ( valeur == o.valeur) {
	    		if (temps < o.temps ) 
	    			return -1 ;
	    		else{
	    			if (temps == o.temps) 
	    				return 1;
	    		}
	    		return 1;
	    	}
	    }
	    return 1 ;
	}
	
}
