package cours;

import java.util.logging.Level;

public class AucunSoin implements Soin {
	  public void soigner() {
		  SimpleLogger.log.log(Level.INFO,"Je ne donne AUCUN soin !");
	  }
	}

