package tda_redéfinition;

public interface Comparateur<T> {
	public int comparer(T x, T y);

	public /*default*/ boolean comparable(T x); /*{
		return true;
	}*/

	public /*default*/ boolean égal(T x, T y) ; /*{
		return this.comparer(x, y) == 0;
	}*/

	public /*default*/ boolean inférieur(T x, T y) ; /*{
		return this.comparer(x, y) < 0;
	}*/

	public /*default*/ boolean inférieurOuEgal(T x, T y); /*{
		return this.comparer(x, y) <= 0;
	}*/

	public /*default*/ boolean supérieur(T x, T y) ; /*{
		return this.comparer(x, y) > 0;
	}*/

	public /*default*/ boolean supérieurOuEgal(T x, T y); /*{
		return this.comparer(x, y) >= 0;
	}*/

}
