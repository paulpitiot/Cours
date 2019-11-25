package tda_red�finition;

public class ComparateurDeCl�Alpha implements Comparateur<String> {

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
	public boolean �gal(String x, String y) {
		return x.compareTo(y) == 0;
	}
	@Override
	public boolean inf�rieur(String x, String y) {
		return x.compareTo(y) < 0;
	}
	@Override
	public boolean inf�rieurOuEgal(String x, String y) {
		// TODO Auto-generated method stub
		return x.compareTo(y) <= 0;
	}
	@Override
	public boolean sup�rieur(String x, String y) {
		// TODO Auto-generated method stub
		return x.compareTo(y) > 0;
	}
	@Override
	public boolean sup�rieurOuEgal(String x, String y) {
		// TODO Auto-generated method stub
		return x.compareTo(y) >= 0;
	}

}
