package cours;

class A
{ public A (int nn)
  { System.out.println ("Entree Constr A - n=" + n + " p=" + p) ;
    n = nn ;
    System.out.println ("Sortie Constr A - n=" + n + " p=" + p) ;
  }
  public int n ;   // ici, exceptionnellement, pas d'encapsulation
  public int p=10 ;
}
class B extends A
{ public B (int n, int pp)
  { super (n) ;
    System.out.println ("Entree Constr B - n=" + n + " p=" + p + " q=" + q) ;
    p = pp ;
    q = 2*n ;
    System.out.println ("Sortie Constr B - n=" + n + " p=" + p + " q=" + q) ;
  }
  public int q=25 ;
}
public class TstInit
{ public static void main (String args[])
  { A a = new A(5) ;
    B b = new B(5, 3) ;
  }
}
