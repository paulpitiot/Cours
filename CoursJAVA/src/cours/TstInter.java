package cours;

interface Affichable
{ public void affiche() ;
}

interface Transformable
{ public void homothetie (double coef) ;
  public void rotation (double angle) ;
}

abstract class FigureInter implements Affichable, Transformable
{
	public static void afficheFigures(FigureInter[] f) {
		for (int i = 0; i < f.length; i++)
			f[i].affiche();
	}

	public static void homothetieFigures(double coef, FigureInter[] f) {
		for (int i = 0; i < f.length; i++)
			f[i].homothetie(coef);
	}

	public static void rotationFigures(double angle, FigureInter[] f) {
		for (int i = 0; i < f.length; i++)
			f[i].rotation(angle);
	}
  
  
}


class PointFigureInter extends FigureInter {
	String nom;
	PointFigureInter(String nom){
		this.nom = nom;
	}
	@Override
	public void affiche() {
		System.out.println("je suis le point "+nom);
	}
	@Override
	public void homothetie(double coef) {
		System.out.println("ça n'a pas de sens!");
	}
	@Override
	public void rotation(double angle) {
		System.out.println("ça n'a pas de sens!");
	}
}

public class TstInter
{ public static void main (String args[])
  {

	PointFigureInter pf1 = new PointFigureInter("A");
	PointFigureInter pf2 = new PointFigureInter("B");
	PointFigureInter pf3 = new PointFigureInter("C");

	FigureInter[] tableauFigure = { pf1, pf2, pf3 };

	FigureInter.afficheFigures(tableauFigure);
  }
}

/* public abstract facultatif dans methodes
*/
