package tda_redéfinition;

public class ComparateurDeCléAlpha implements Comparateur<String> {

	@Override
	public int comparer(String x, String y) {
		return x.compareTo(y);
	}
	@Override
	public boolean comparable(String x) {
		return (x == null) ? false : String.class
				.isAssignableFrom(x.getClass());
	}
	@Override
	public boolean égal(String x, String y) {
		return x.compareTo(y) == 0;
	}
	@Override
	public boolean inférieur(String x, String y) {
		return x.compareTo(y) < 0;
	}
	@Override
	public boolean inférieurOuEgal(String x, String y) {
		// TODO Auto-generated method stub
		return x.compareTo(y) <= 0;
	}
	@Override
	public boolean supérieur(String x, String y) {
		// TODO Auto-generated method stub
		return x.compareTo(y) > 0;
	}
	@Override
	public boolean supérieurOuEgal(String x, String y) {
		// TODO Auto-generated method stub
		return x.compareTo(y) >= 0;
	}

}
