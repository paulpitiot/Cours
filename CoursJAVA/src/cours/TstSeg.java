package cours;
class Point 
{ public Point (double x, double y)          { this.x = x ;  this.y = y ; }
  public void deplace (double dx, double dy) { x += dx ;     y += dy ;    }
  public double getX () { return x ; }
  public double getY () { return y ; }
  public void setX (double x) { this.x = x ; }
  public void setY (double y) { this.y = y ; }
  public void affiche ()
  { System.out.println ("coordonnees = " + x + " " + y ) ;
  }
  private double x, y ;

}
class Segment
{ public Segment (Point or, Point ext)
  { this.or = or ; this.ext = ext ;
  }
  public Segment (double xOr, double yOr, double xExt, double yExt)
  { or =  new Point (xOr, yOr) ;
    ext = new Point (xExt, yExt) ;
  }
  public double longueur()
  { double xOr =  or.getX(),  yOr =  or.getY() ;
    double xExt = ext.getX(), yExt = ext.getY() ;
    return Math.sqrt ( (xExt-xOr)*(xExt-xOr) + (yExt-yOr)*(yExt-yOr) ) ;
  }
  public void deplaceOrigine (double dx, double dy)
  { or.setX (or.getX() + dx) ;
    or.setY (or.getY() + dy) ;
  }
  public void deplaceExtremite (double dx, double dy)
  { ext.setX (ext.getX() + dx) ;
    ext.setY (ext.getY() + dy) ;
  }
  public void affiche ()
  { System.out.print ("Origine -   ") ; or.affiche() ;
    System.out.print ("Extremite - ") ; ext.affiche() ;
  }
  private Point or, ext ;
}
public class TstSeg
{ public static void main (String args[])
  { Point a = new Point(1, 3) ;
    Point b = new Point(4, 8) ;
    a.affiche() ; b.affiche() ;
    Segment s1 = new Segment (a, b) ;
    s1.affiche() ;
    s1.deplaceOrigine (2, 5) ;
    s1.affiche() ;
    Segment s2 = new Segment (3, 4, 5, 6) ;
    s2.affiche() ;
    System.out.println ("longeur = " + s2.longueur()) ;
    s2.deplaceExtremite (-2, -2) ;
    s2.affiche() ;
  }
}



