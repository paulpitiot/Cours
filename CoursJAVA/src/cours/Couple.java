package cours;

public class Couple<T> {
	private T x,y;		// les deux �l�ments du couple
	public Couple(T premier, T second){
		x = premier; y = second;
	}
	public void affiche(){
		System.out.println("premiere valeur : " + x + " - deuxi�me valeur : " + y);
	}
}
