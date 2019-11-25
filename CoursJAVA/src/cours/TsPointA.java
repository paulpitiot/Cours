package cours;

class PointU {
	 private int x, y ;
	 public void initialise (int x, int y) { this.x = x; this.y = y;}
	 public void deplace (int dx, int dy)  { x += dx ; y += dy ; }
	 protected int getX() { return x; }
	 protected int getY() { return y; }

}

class PointA extends PointU
{ void affiche()
  { System.out.println ("Coordonnees : " + getX() + " " + getY()) ;
  }
}

public class TsPointA
{ public static void main (String args[])
  { PointU p = new PointU() ;
    p.initialise (2, 5) ;
    System.out.println ("Coordonnees : " + p.getX() + " " + p.getY() ) ;
    PointA pa = new PointA() ;
    pa.initialise (1, 8) ;  // on utilise la methode initialise de Point
    pa.affiche() ;          // et la méthode affiche de PointA
    
  }

}

