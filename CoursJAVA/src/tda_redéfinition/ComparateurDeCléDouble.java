package tda_redéfinition;

public class ComparateurDeCléDouble implements Comparateur<Double> {

		public int comparer(Double x, Double y) {
			if(x<y)
				return -1;
			else {
				if(x==y) // a modifier bp égalité réel
					return 0;
				else
					return 1;
			}
		}
		
		public boolean comparable(Double x) {
			return true;
		}
		public boolean égal(Double x, Double y) {
			return x == y;  // à modifier cf bp réel!
		}
		public boolean inférieur(Double x, Double y) {
			return x < y;
		}
		public boolean inférieurOuEgal(Double x, Double y) {
			return x <= y;
		}
		public boolean supérieur(Double x, Double y) {
			return x > y;
		}
		public boolean supérieurOuEgal(Double x, Double y) {
			return x >= y;
		}

	}
