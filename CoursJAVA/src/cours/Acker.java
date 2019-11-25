package cours;

import java.util.logging.Level;

class Util
{
	private Util(){
		
	}
public static int acker (int m, int n)
  { if ( (m<0) || (n<0) ) return 0 ;
    else if (m == 0) return n+1 ;
    else if (n == 0) return acker (m-1, 1) ;
    else return acker (m-1, acker(m, n-1)) ;
  }
}

public class Acker
{ public static void main (String args [])
  { int m;
  	int n ;
  	SimpleLogger.log.log(Level.INFO,"Premier parametre : ") ;
    m = Clavier.lireInt() ;
    SimpleLogger.log.log(Level.INFO,"Second parametre  : ") ;
    n = Clavier.lireInt() ;
    SimpleLogger.log.log(Level.INFO,"acker (" + m + ", " + n + ") = " + Util.acker(m, n)) ;
  }
}
