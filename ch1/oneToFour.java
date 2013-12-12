package ch1;

//public class oneToFour{
//	public static void Main(){
//		System.out.println(strAna("abc", "abc"));	
//	}

//	public static boolean strAna(String A, String B){
//		int lenA = A.length();
//		int lenB = B.length();
//		if (lenA != lenB) return false;
//		for (int i=0; i<lenA; ++i){
//			if (A[i] != B[i]) return false;
//		}
//		return true;
//	}

import java.util.HashMap;
import java.util.Map;

public class oneToFour{
	public static boolean anagram(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		return frequencyMap(s).equals(frequencyMap(t));
	}

	private static Map<Character, Integer> frequencyMap(String str){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c:str.toLowerCase().toCharArray()){
			Integer frequency = map.get(c);
			map.put(c, frequency==null ? 1:frequency+1);
		}
		return map;
	}
	
	public static void main(String[] args){
		String s="Mary";
		String t="Army";
		System.out.println(anagram(s, t));
		System.out.println(anagram("Aarmy", t));
	}
}
