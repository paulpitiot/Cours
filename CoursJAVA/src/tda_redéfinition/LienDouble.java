package tda_red�finition;

public class LienDouble<T> extends Lien<T> {
	protected Lien<T> precedent;

	protected Lien<T> precedent() {
		return precedent;
	}

	protected void precedent(Lien<T> s) {
		precedent = s;
	}

}
