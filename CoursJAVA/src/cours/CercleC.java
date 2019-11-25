package cours;

public class CercleC implements Comparable<CercleC>
{ public CercleC (int x, int y, double rayon)
  { this.x = x ; this.y = y ; this.rayon = rayon ; }
  public void affiche ()
  { System.out.println ("Coordonnees : " + x + ", " + y
                        + " ; rayon : " + rayon) ;
  }
  public int compareTo (CercleC c)
  { if (rayon < c.rayon ) return -1 ;
    else {
    	if ( rayon == c.rayon) {
    		if((x == c.getX())&& (y == c.getY())){  // tout coup par ordre de saisie si même rayon
    	        	return 0 ;
    		}
    		return 1;
    	}
    }
    return 1 ;
  }
  public double getRayon () { return rayon ; }  
  public int getX () { return x ; }             
  public int getY () { return y ; }         
  private int x, y ;
  double rayon ;

}