package oop.concur.ext;

/**
 * Simple class implementing a matrix.
 * 
 * @author aricci
 *
 */
public class Mat {

	private double[][] mat;

	public Mat(int n, int m) {
		mat = new double[n][m];
	}

	public void initRandom(double factor) {
		java.util.Random rand = new java.util.Random();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = (int) (rand.nextDouble() * factor);
				// mat[i][j] = rand.nextDouble();
			}
		}
	}

	public void set(int i, int j, double v) {
		mat[i][j] = v;
	}

	public double get(int i, int j) {
		return mat[i][j];
	}

	public int getNRows() {
		return mat.length;
	}

	public int getNColumns() {
		return mat[0].length;
	}
	
	public void print() {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(" " + mat[i][j]);
			}
			System.out.println();
		}
	}
}
