package cours;


import java.util.logging.Level;

import java.util.logging.Logger;

public class SimpleLogger {

	static Logger log = Logger.getLogger("logger");
	
	static public void logInfo(String s){
		log.log(Level.INFO,s);
	}
	/**

	* @param args

	*/

	public static void main(String[] args) {

	log.log(Level.INFO, "Test de logger");

	}
}
