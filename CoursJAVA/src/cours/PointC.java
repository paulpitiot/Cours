package cours;

class PointC implements Comparable <PointC> 
{ private int x, y ;
  PointC (int x, int y)
  { this.x = x ; this.y = y ;
  }
  public void affiche()
  { System.out.println ("coordonnees : " + x + " " + y ) ;
  }

@Override
public int compareTo(PointC p) {
	int norme1 = x * x + y * y ;
    int norme2 = p.x * p.x + p.y * p.y ;
    if (norme1 == norme2) return 0 ;
    if (norme1 > norme2)  return 1 ;
                     else return -1 ;
}

}
