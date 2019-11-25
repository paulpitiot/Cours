package cours;

import java.util.logging.Level;

@SuppressWarnings("serial")
class Erreur extends Exception {
	public final int num;

	public Erreur(int num) {
		super();
		this.num = num;
	}

}

@SuppressWarnings("serial")
class Erreurd extends Erreur {
	public final int code;

	public Erreurd(int num, int code) {
		super(num);
		this.code = code;
	}
	
}

class AA {
	public AA(int n) throws Erreurd {
		if (n == 1) {
			Erreurd e = new Erreurd(999,12);
			throw e;
		}
	}
}

public class Chemin1 {
	@SuppressWarnings({ "unused", "hiding" })
	public static void main(String args[]) {
		try {
			AA a = new AA(1);
			SimpleLogger.log.log(Level.INFO,"apres creation a(1)");
		} catch (Erreur e) {
			SimpleLogger.log.log(Level.INFO,"** exception Erreur " + e.num);
		}
		System.out.println("suite main");
		try {
			AA b = new AA(1);
			SimpleLogger.log.log(Level.INFO,"apres creation b(1)");
		} catch (Erreurd e) {
			SimpleLogger.log.log(Level.INFO,"** exception Erreur_d " + e.num + " " + e.code);
		} catch (Erreur e) {
			SimpleLogger.log.log(Level.INFO,"** exception Erreur " + e.num);
		}
	}
}

/*
 ** exception Erreur 999 suite main exception Erreur_d 999 12
 */
