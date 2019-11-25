package cours;

public abstract class Figure {
	abstract public void affiche();

	abstract public void homothetie(double coef);

	abstract public void rotation(double angle);

	public void HomoRot(double coef, double angle) {
		homothetie(coef);
		rotation(angle);
	}

	public static void afficheFigures(Figure[] f) {
		for (int i = 0; i < f.length; i++)
			f[i].affiche();
	}

	public static void homothetieFigures(double coef, Figure[] f) {
		for (int i = 0; i < f.length; i++)
			f[i].homothetie(coef);
	}

	public static void rotationFigures(double angle, Figure[] f) {
		for (int i = 0; i < f.length; i++)
			f[i].rotation(angle);
	}
	
	public static void main(String args[]) {

		PointFigure pf1 = new PointFigure("A");
		PointFigure pf2 = new PointFigure("B");
		PointFigure pf3 = new PointFigure("C");

		Figure[] tableauFigure = { pf1, pf2, pf3 };

		Figure.afficheFigures(tableauFigure);

	}
}

class PointFigure extends Figure {
	String nom;
	PointFigure(String nom){
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
