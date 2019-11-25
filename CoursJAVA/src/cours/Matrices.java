package cours;

import java.util.Arrays;

public class Matrices {

	public static void main(String[] args) {
		int mat[][] = new int [12][];
		for (int i = 0 ; i<12; i++){
			mat[i] = new int [12];
			for (int j = 0; j < 12 ; j++){
				mat[i][j] =  (i+1)*(j+1);
			}
		}
		System.out.println(Arrays.deepToString(mat));
	}

}
