package cours;

@SuppressWarnings("serial")
class Except extends Exception
{}
public class Finally
{ public static void f(int n)
  { try
    { if (n!=1) throw new Except () ;
    }
    catch (Except e)
    { System.out.println ("catch dans f - n = " + n) ;
      return ;
    }
    finally
    { System.out.println ("dans finally - n = " + n) ;
    }
  }
  public static void main (String args[])
  {
    f(1) ;
    f(2) ;
  }
}

 /*
dans finally - n = 1
catch dans f - n = 2
dans finally - n = 2
*/


