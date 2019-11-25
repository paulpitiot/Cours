package cours;

public class TstStatic {
public static void main (String args[])
{ C<Integer> ci = new C<Integer>();
	ci.affiche();
	C<Double> cd = new C<Double>();
	ci.affiche();  cd.affiche();
	Class<?> cci = ci.getClass();
	Class<?> ccd = cd.getClass();
	if (cci == ccd) System.out.println("ci et cd sont de la même classe");
	else System.out.println("ci et cd ne sont pas de la même classe");
	System.out.println(cci.getName() + " " + ccd.getName());
}
}

class C<T>
{ public C () {compte++;}
public void affiche()
{System.out.println("compte = " + compte);}

private static int compte = 0;
}
