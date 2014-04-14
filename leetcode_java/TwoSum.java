package leetcode_140;

import java.util.HashMap;

public class TwoSum {
	public static void main(String args[]){
		int[] numbers={2, 7, 11, 15};
		int target=9;
		System.out.println(twoSum(numbers, target)[0]);
		System.out.println(twoSum2(numbers, target)[0]);
	}
	
	public static int[] twoSum2(int[] numbers, int target) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int[] resultVal = new int[2];
	    for(int i = 0; i < numbers.length; i ++) {
	        if(map.containsKey(numbers[i])) {
	            int index = map.get(numbers[i]);
	            if(index < i) {
	                resultVal[0] = index + 1;
	                resultVal[1] = i + 1;
	                break;
	            }
	        } 
	        if(!map.containsKey(numbers[i]))
	            map.put(target - numbers[i], i);
	    }

	    return resultVal; 
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int[] result = new int[2];
		int length = numbers.length;
		for (int i = 0; i < length; i++) {
			int toFind = target - numbers[i];
			for (int j = i + 1; j < length; j++) {
				if (numbers[j] == toFind) {
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}
			}
		}
		return result;
	}
}
