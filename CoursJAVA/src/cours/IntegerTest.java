package cours;

public class IntegerTest {

	public static void main(String[] args) {

		// exo 27
		int n, p;

		n = 0;
		while (n <= 5)
			n++;
		System.out.println("A : n = " + n);

		n = p = 0;
		while (n <= 8)
			n += p++;
		System.out.println("B : n = " + n);

		n = p = 0;
		while (n <= 8)
			n += ++p;
		System.out.println("C : n = " + n);

		n = p = 0;
		while (p <= 5)
			n += p++;
		System.out.println("D : n = " + n);

		n = p = 0;
		while (p <= 5)
			n += ++p;
		System.out.println("D : n = " + n);
	}

}
