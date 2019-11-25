package cours;
import java.util.* ;

public class TestListeTri�eChamps
{ public static void main (String args [])
  { ListeTri�eChamps liste = new ListeTri�eChamps ()  ;
    liste.ajoute ("c") ;
    liste.affiche() ;
    liste.ajoute ("b") ;
    liste.affiche() ;
    liste.ajoute ("f") ;
    liste.affiche() ;
    liste.ajoute ("e") ;
    liste.affiche() ;
  }  
}
class ListeTri�eChamps
{ public ListeTri�eChamps ()
  { liste = new LinkedList <String> () ;  // ou ArrayList
  }
  public void ajoute (String ch)
  { ListIterator <String> it = liste.listIterator () ;
    boolean trouve = false ;
    while ((it.hasNext()) && ! trouve)
    { if (it.next().compareTo(ch) > 0) trouve = true ;
    } 
    if (trouve) it.previous() ;    // ici, il y obligatoirement un precedent
    it.add (ch) ;
  }
  public void affiche ()
  { 
    for (String ch : liste) System.out.print (ch + " ") ;
    System.out.println () ;
  }
  private LinkedList <String> liste ;    // ou ArrayList
}