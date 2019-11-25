package cours;

public class TstDerivCouple
{ public static void main (String args[])
  { Couple <Double> cd1 = new Couple <Double> (5.0, 2.5) ;
    cd1.affiche () ;
    Couple <Double> cd2 = new Couple <Double> (5.0, 2.5) ;
    cd2.affiche () ;
    CoupleNomme <String> cns 
           = new CoupleNomme <String> ("hello", "bonjour", "saluts") ;
    cns.affiche () ;
    CoupleNomme <Couple<Double>> cnd 
           = new CoupleNomme <Couple<Double>> (cd1, cd2, "cf1") ;
    cnd.affiche () ;
    PointNomme p1 = new PointNomme (2, 5, "Point1") ;
    p1.affiche() ;
   }
}
