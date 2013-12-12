package leetcode_140;

public class BinarySearch{
	public static void main(String args[]){
		int[] A= new int[4];
		A[0] = 1;
		A[1] = 2;
		A[2] = 4;
		A[3] = 7;
		int answer = binarySearch(A, 12, 0, A.length);
		System.out.println(answer);
	}

	private static int binarySearch(int A[], int a, int head, int tail){
		if(head>tail){
			return 0;
		} else {
			int mid = (head+tail)/2;
			if(a==A[mid]||mid==head||head==tail) return mid;
			if(a<A[mid]) return binarySearch(A, a, head, mid-1);
			if(a>A[mid]) return binarySearch(A, a, mid+1, tail);
		}
		return 0;
	}
}
