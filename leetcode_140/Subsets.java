package leetcode_140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Subsets {
	public static void main(String args[]) {
		int[] a = {4,1,0};
		System.out.println(subsets(a));
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<ArrayList<Integer>> allSubSet = new ArrayList<ArrayList<Integer>>();
	    if (S == null || S.length == 0) {
	    	return allSubSet;
	    }
		ArrayList<Integer> s = new ArrayList<Integer>();
		for (int i = 0; i < S.length; i++) {
			s.add(S[i]);
		}
		Collections.sort(s);
		System.out.println(s);
		ArrayList<ArrayList<Integer>> result = help(s, allSubSet);
		Collections.reverse(result);
		return result;
	}

	public static ArrayList<ArrayList<Integer>> help(ArrayList<Integer> s, 
			ArrayList<ArrayList<Integer>> allSubSet) {
		if (s.size() == 0) {
			allSubSet.add(new ArrayList<Integer>());
			return allSubSet;
		} else {
			int first = s.remove(0);
			ArrayList<ArrayList<Integer>> elements = help(s, allSubSet);
			int total = elements.size();
			for (int i=0; i<total; i++) {
				elements.add((ArrayList<Integer>)elements.get(i).clone());
				elements.get(i).add(0, first);
			}
			return allSubSet;
		}
	}
}
