package leetcode_140;

public class UniquePaths {
	public static void main(String args[]) {
		// System.out.println("test:" + uniquePaths(2, 2));
		System.out.println("test:" + dp(2, 2));
	}

	private static int dp(int m, int n) {
		int[][] mat = new int[m + 2][n + 2];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				mat[i][j] = 0;
			}
		}
		mat[m][n + 1] = 1;

		for (int r = m; r >= 1; r--)
			for (int c = n; c >= 1; c--)
				mat[r][c] = mat[r + 1][c] + mat[r][c + 1];

		return mat[1][1];
	}

	private static int uniquePaths(int m, int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int[][] board = new int[m + 2][n + 2];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				board[i][j] = -1;
			}
		}
		// !!! if r==1 and c==1 we already find one
		return backtrack(m, n, 1, 1, board);
	}

	private static int backtrack(int m, int n, int r, int c, int[][] board) {
		if (r == m && c == n)
			return 1;
		if (r > m || c > n)
			return 0;

		if (board[r + 1][c] == -1) {
			board[r + 1][c] = backtrack(m, n, r + 1, c, board);
		}
		if (board[r][c + 1] == -1) {
			board[r][c + 1] = backtrack(m, n, r, c + 1, board);
		}
		return board[r + 1][c] + board[r][c + 1];
	}

	private static void printBoard(int m, int n, int[][] board) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
