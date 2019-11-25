package tda_red�finition;

public interface Comparateur<T> {
	public int comparer(T x, T y);

	public /*default*/ boolean comparable(T x); /*{
		return true;
	}*/

	public /*default*/ boolean �gal(T x, T y) ; /*{
		return this.comparer(x, y) == 0;
	}*/

	public /*default*/ boolean inf�rieur(T x, T y) ; /*{
		return this.comparer(x, y) < 0;
	}*/

	public /*default*/ boolean inf�rieurOuEgal(T x, T y); /*{
		return this.comparer(x, y) <= 0;
	}*/

	public /*default*/ boolean sup�rieur(T x, T y) ; /*{
		return this.comparer(x, y) > 0;
	}*/

	public /*default*/ boolean sup�rieurOuEgal(T x, T y); /*{
		return this.comparer(x, y) >= 0;
	}*/

}
