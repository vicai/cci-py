package leetcode_140;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String args[]) {
		System.out
				.println(lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));
	}

	public static int lengthOfLongestSubstring(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		HashMap chars = new HashMap();
		int head = 0;
		int tail = 0;
		int length = 0;
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if ((chars.get(s.charAt(i)) == null)) {
				chars.put(s.charAt(i), 1);
				result += s.charAt(i);
				tail++;
				System.out.println(".." + result);
			} else {
				System.out.println(result);
				if (result.length() > length) {
					length = result.length();
				}
				head += result.indexOf(s.charAt(i)) + 1;
				tail++;
				chars = new HashMap();
				result = s.substring(head, tail);
				for (int j = 0; j < result.length(); j++) {
					chars.put(result.charAt(j), 1);
				}
			}
		}
		return length;
	}
}
