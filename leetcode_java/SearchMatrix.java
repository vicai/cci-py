package leetcode_140;

public class SearchMatrix {
	public static void main(String args[]){
		int[][] test = {{1}};
		int target=2;
		System.out.println(fastSearchMatrix(test, target));
	}
	
	public static boolean fastSearchMatrix(int[][] matrix, int target){
		int rowN=matrix.length;
		int colN=matrix[0].length;
		int low=0;
		int high = rowN*colN-1;
		while(low<=high){
			int mid = (low+high)/2;
			if (matrix[mid/colN][mid%colN]==target) return true;
			else if(matrix[mid/colN][mid%colN] > target){
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return false;
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int rowN = matrix.length;
		int colN = matrix[0].length;
		int row = 0;
		int col = 0;
		while (row < rowN && matrix[row][0] <= target) {
            if (matrix[row][0]==target){
                return true;
            }
			row++;
		}
		while (col < colN) {
			if (row==0) return false;
			if (matrix[row-1][col] == target)
				return true;
			col++;
		}
		return false;
	}
}
