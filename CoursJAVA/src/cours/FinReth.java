package cours;


public class FinReth
{ public static void f(int n) throws Excep
  { try
    { if (n!=1) throw new Excep() ;
    }
    catch (Excep e)
    { System.out.println ("catch dans f - n = " + n) ;
      throw e ;
    }
    finally
    { System.out.println ("dans finally de f - n = " + n) ;
    }
  }
  public static void main (String args[])
  { int n=0 ;
    try
    { for (n=1 ; n<5 ; n++) f(n) ;
    }
    catch (Excep e)
    { System.out.println ("catch dans main - n = " + n) ;
    }
    finally
    { System.out.println ("dans finally de main - n = " + n) ;
    }
  }
}
class Excep extends Exception
{
	private static final long serialVersionUID = 1L;}

/*
dans finally de f - n = 1
catch dans f - n = 2
dans finally de f - n = 2
catch dans main - n = 2
dans finally de main - n = 2

*/


