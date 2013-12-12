package leetcode_140;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
	public static void main(String args[]) {
		int[] A = new int[4];
		int[] B = new int[3];
		A[0] = 4;
		A[1] = 5;
		A[2] = 6;
		A[3] = 7;
		B[0] = 1;
		B[1] = 2;
		B[2] = 3;
		System.out.println(findMedianSortedArrays(A, B));
	}

	public static double findMedianSingleArray(int A[]) {
		if (A.length > 0) {
			return (A.length % 2 == 0) ? (A[A.length/2] + A[A.length/2 - 1]) / 2.0
					: A[A.length / 2];
		}
		return 0;
	}

	public static double findMedianBaseCase(int med, int A[]) {
		int n = A.length;
		// A and B length both 1
		if (n == 1) {
			return (med + A[0]) / 2.0;
		}
		if (n % 2 == 0) {
			int a = A[n / 2 - 1], b = A[n / 2];
			if (med <= a)
				return a;
			else if (med <= b)
				return med;
			else
				return b;
		} else {
			int a = A[n / 2 - 1], b = A[n / 2], c = A[n / 2 + 1];
			if (med <= a)
				return (a + b) / 2.0;
			else if (med <= c)
				return (med + b) / 2.0;
			else
				return (b + c) / 2.0;
		}
	}

	public static double findMedianBaseCase2(int med1, int med2, int A[]) {
		int n = A.length;
		if (n % 2 == 0) {
			int a = (((n / 2 - 2) >= 0) ? A[n / 2 - 2] : Integer.MIN_VALUE);
			int b = A[n / 2 - 1], c = A[n / 2];
			int d = (((n / 2 + 1) <= n - 1) ? A[n / 2 + 1] : Integer.MAX_VALUE);
			if (med2 <= b)
				return (b + Math.max(med2, a)) / 2.0;
			else if (med1 <= b)
				return (b + Math.min(med2, c)) / 2.0;
			else if (med1 >= c)
				return (c + Math.min(med1, d)) / 2.0;
			else if (med2 >= c)
				return (c + Math.max(med1, b)) / 2.0;
			else
				/* a < med1 <= med2 < b */
				return (med1 + med2) / 2.0;
		} else {
			int a = A[n / 2 - 1], b = A[n / 2], c = A[n / 2 + 1];
			if (med1 >= b)
				return Math.min(med1, c);
			else if (med2 <= b)
				return Math.max(med2, a);
			else
				/* med1 < b < med2 */
				return b;
		}
	}

	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		System.out.println(m);
		System.out.println(n);
		if (m == 0)
			return findMedianSingleArray(B);
		else if (n == 0)
			return findMedianSingleArray(A);
		else if (m == 1)
			return findMedianBaseCase(A[0], B);
		else if (n == 1)
			return findMedianBaseCase(B[0], A);
		else if (m == 2)
			return findMedianBaseCase2(A[0], A[1], B);
		else if (n == 2)
			return findMedianBaseCase2(B[0], B[1], A);

		int i = m / 2, j = n / 2, k;
		if (A[i] <= B[j]) {
			k = ((m % 2 == 0) ? Math.min(i - 1, n - j - 1) : Math.min(i, n - j - 1));
			System.out.println(Arrays.toString(Arrays.copyOfRange(A, k, m)));
			System.out.println(Arrays.toString(Arrays.copyOfRange(B, 0, n-k)));
			return findMedianSortedArrays(Arrays.copyOfRange(A, k, m), Arrays.copyOfRange(B, 0, n-k));
		} else {
			k = ((n % 2 == 0) ? Math.min(m - i - 1, j - 1) : Math.min(m - i - 1, j));
			System.out.println(Arrays.toString(Arrays.copyOfRange(A, 0, m-k)));
			System.out.println(Arrays.toString(Arrays.copyOfRange(B, k, m-1)));
			return findMedianSortedArrays(Arrays.copyOfRange(A, 0, m-k), Arrays.copyOfRange(B, k, n));
		}
	}

//	/**
//	 * The O(n) solution with bugs --!
//	 * 
//	 * @param A
//	 * @param B
//	 * @return
//	 */
//	public static double findMedianSortedArrays2(int A[], int B[]) {
//		// IMPORTANT: Please reset any member data you declared, as
//		// the same Solution instance will be reused for each test case.
//		int i = 0;
//		int j = 0;
//		int counter = 0;
//		int last;
//		int total = A.length + B.length;
//		if (A.length == 0 && B.length == 0)
//			return 0;
//		else if (A.length == 0) {
//			if (B.length % 2 == 1)
//				return B[B.length / 2];
//			else
//				return (B[B.length / 2] + B[B.length / 2 - 1]) / 2;
//		} else if (B.length == 0) {
//			if (A.length % 2 == 1)
//				return A[A.length / 2];
//			else
//				return (A[A.length / 2] + A[A.length / 2 - 1]) / 2;
//		}
//		if (total % 2 == 1) {
//			while (counter < total / 2) {
//				if (A[i] < B[j]) {
//					i++;
//				} else {
//					j++;
//				}
//				counter++;
//				if (i == A.length)
//					i--;
//				if (j == B.length)
//					j--;
//			}
//			return Math.min(A[i], B[j]);
//		} else {
//			while (counter < total / 2) {
//				if (A[i] < B[j]) {
//					last = A[i];
//					i++;
//				} else {
//					last = B[j];
//					j++;
//				}
//				counter++;
//				if (i == A.length)
//					i--;
//				if (j == B.length)
//					j--;
//			}
//			return (A[i] + B[j]) / 2;
//		}
//	}
}