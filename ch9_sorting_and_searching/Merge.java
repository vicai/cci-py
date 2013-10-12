package ch9_sorting_and_searching;

public class Merge{
	public void merge(int[] A, int[] B, m, n){
		//@require m+n < A.length
	int k=m+n-1;
	int i = n-1;
	int j=m-1;

	while(i>=0 && j>= 0){
		if(a[i] > b[j]){
			a[k--] = a[i--];
		}
	}
}
