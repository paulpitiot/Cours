package tda_red�finition;

public class ComparateurDeCl�Double implements Comparateur<Double> {

		public int comparer(Double x, Double y) {
			if(x<y)
				return -1;
			else {
				if(x==y) // a modifier bp �galit� r�el
					return 0;
				else
					return 1;
			}
		}
		
		public boolean comparable(Double x) {
			return true;
		}
		public boolean �gal(Double x, Double y) {
			return x == y;  // � modifier cf bp r�el!
		}
		public boolean inf�rieur(Double x, Double y) {
			return x < y;
		}
		public boolean inf�rieurOuEgal(Double x, Double y) {
			return x <= y;
		}
		public boolean sup�rieur(Double x, Double y) {
			return x > y;
		}
		public boolean sup�rieurOuEgal(Double x, Double y) {
			return x >= y;
		}

	}
