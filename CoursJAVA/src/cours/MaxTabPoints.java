package cours;

public class MaxTabPoints
{ public static void main (String args[])
  { PointC p1 = new PointC (0, 5) ;
    PointC p2 = new PointC (3, 1) ;
    PointC p3 = new PointC (0, 12) ;
    PointC p4 = new PointC (3, 5) ;
    PointC [] tp = {p1, p2, p3, p4} ;
    PointC maxp = max (tp) ;
    System.out.println ("Point maxi : ") ;
    maxp.affiche() ;
    tp[4].affiche();
  }
  static <T extends Comparable <T> > T max (T[] valeurs)  // ou pour être complètement générique : plutôt <T extends Comparable <? super T>
  {  if (valeurs == null) return null ;
     if (valeurs.length == 0) return null ;
     T maxi = valeurs[0] ;
     for (T v : valeurs) if (v.compareTo(maxi) > 0) maxi = v ;
     return maxi ;
  }
}
