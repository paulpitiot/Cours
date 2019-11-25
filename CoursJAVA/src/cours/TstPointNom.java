package cours;

class PointN
{ public void setPoint (int x, int y)  { this.x = x ; this.y = y ; }
  public void deplace (int dx, int dy) { x += dx ; y += dy ; }
  public void affCoord ()
  { System.out.println ("Coordonnees : " + x + " " + y) ;
  }
  private int x, y ;
}

class PointNom extends PointN
{ public void setPointNom (int x, int y, char nom)
  { setPoint (x, y) ;
    this.nom = nom ;
  }
  public void setNom(char nom)
  { this.nom = nom ;
  }
  public void affCoordNom()
  { System.out.print ("Point de nom " + nom + " ") ;
    affCoord() ;
  }
  private char nom ;
}

public class TstPointNom
{ public static void main (String args[])
  { PointN p = new PointN () ;
    p.setPoint (2, 5) ;
    p.affCoord() ;
    PointNom pn1 = new PointNom() ;
    pn1.setPointNom (1, 7, 'A') ;      // methode de PointNom
    pn1.affCoordNom() ;                // methode de PointNom
    pn1.deplace (9, 3) ;               // methode de Point
    pn1.affCoordNom() ;                // methode de PointNom

    PointNom pn2 = new PointNom() ;
    pn2.setPoint (4, 3) ;               // methode de Point
    pn2.setNom ('B') ;                  // methode de PointNom
    pn2.affCoordNom() ;                 // methode de PointNom
    pn2.affCoord() ;                    // methode de Point
  }
}

