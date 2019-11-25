package cours;
// classe fournissant des fonctions de lecture au clavier
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Clavier
{ public static String lireString ()   // lecture d'une chaine
  { String ligne_lue = null ;
    try
    { 
      InputStreamReader lecteur = new InputStreamReader (System.in) ;
      BufferedReader entree = new BufferedReader (lecteur);
      ligne_lue = entree.readLine() ;
    }
    catch (IOException err)
    { lireString ();
    }
    return ligne_lue ;
  }
/* Reste a faire */
  public static float lireFloat ()   // lecture d'un float
  { float x=0 ;   // valeur a lire
    try
    { String ligne_lue = lireString() ;
      x = Float.parseFloat(ligne_lue) ;
    }
    catch (NumberFormatException err)
    { System.out.println ("*** Erreur de donnee resaisir le float ***") ;
      return lireFloat () ;
    }
    return x ;
  }
  /* Reste a faire */
  public static double lireDouble ()   // lecture d'un double
  { double x=0 ;   // valeur a lire
    try
    { String ligne_lue = lireString() ;
      x = Double.parseDouble(ligne_lue) ;
    }
    catch (NumberFormatException err)
    { System.out.println ("*** Erreur de donnee resaisir le double ***") ;
      return lireDouble();
    }
    return x ;
  }
  /* Reste a faire */
  public static int lireInt ()         // lecture d'un int
  { int n=0 ;   // valeur a lire
    try
    { String ligne_lue = lireString() ;
      n = Integer.parseInt(ligne_lue) ;
      }
    catch (NumberFormatException err)
    { System.out.println ("*** Erreur de donnee resaisir le int ***") ;
    return lireInt();
    }
    return n ;
  }

   // programme de test de la classe Clavier
  public static void main (String[] args)
  { System.out.println ("donnez un flottant") ;
    float x ;
    x = Clavier.lireFloat() ;
    System.out.println ("merci pour " + x) ;
    System.out.println ("donnez un entier") ;
    int n  ;
    n = Clavier.lireInt() ;
    System.out.println ("merci pour " + n) ;
    System.out.println ("donnez une ligne de texte") ;
    String ch = Clavier.lireString() ;
    System.out.println ("merci pour " + ch) ;
  }
}


