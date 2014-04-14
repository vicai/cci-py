package leetcode_140;

public class ReverseInteger {
	public int reverse(int x) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if(x>0){
			String y = Integer.toString(x);
			String reverse = new StringBuffer(y).reverse().toString();
			return Integer.parseInt(reverse);
		}
		if (x<0){
			x = -x;
			String y = Integer.toString(x);
			String reverse = new StringBuffer(y).reverse().toString();
			return -Integer.parseInt(reverse);
		}
	    return 0;
	}
}


























