package leetcode_140;

public class MNMatrix {
	public static void main(String args[]) {
		int[][] a = {{1},{0}};
		print(a);
		setZeroes(a);
		print(a);
	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void setZeroes(int[][] matrix) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int first = 0;
		int second = 0;
		int third = 0;
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				second = 1;
			}
		}
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[j][0] == 0) {
				third = 1;
			}
		}
		if (matrix[0][0] == 0 || (second==1 && third==1)) {
			first = 1;
		}
		System.out.println("first:"+second);
		for (int m = 1; m < matrix.length; m++) {
			for (int n = 1; n < matrix[0].length; n++) {
				if (matrix[m][n] == 0) {
					matrix[0][n] = 0;
					matrix[m][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 1; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		for (int j = 1; j < matrix.length; j++) {
			if (matrix[j][0] == 0) {
				for (int i = 1; i < matrix[0].length; i++) {
					matrix[j][i] = 0;
				}
			}
		}
		if (first == 1) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][0] = 0;
			}
		} else if (second == 1) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		} else if (third == 1) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][0] = 0;
			}
		}
	}
}
