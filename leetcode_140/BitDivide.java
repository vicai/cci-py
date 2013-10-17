package leetcode_140;

public class BitDivide {
	public static void main(String args[]){
		System.out.println(divide(2147483647, 1));
		System.out.println(divide(2147483647, 2));
		System.out.println(divide(9,-1));
		System.out.println(divide(-2147483648, 1));
	}
	
	public static int divide(int dividend, int divisor){
		// caution:!! double
		long a = (long) Math.abs((double)dividend);
		long b = (long) Math.abs((double)divisor);
		long ret = 0;
		while (a>=b){
			long c = b;
			for(int i=0; a>=c; ++i, c<<=1){
				a-=c;
				ret += 1<<i;
			}
		}
		//!!!!! right bit shift!
		return (int) ((((dividend^divisor)>>31)==-1) ? (-ret) : (ret));
	}
	
	/**
	 * My own method too slow? why
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divideTooSlow(int dividend, int divisor) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (divisor == 0) {
			throw new IllegalArgumentException("Argument 'divisor' is 0");
		}
		if (divisor == 1){
			return dividend;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int count = 0;
		int trial = divisor;
		while (dividend >= trial) {
			trial <<= 1;
			count++;
		}
		int maxTwoPower = count - 1;
		System.out.println(maxTwoPower);
		int ret = 0;
		int remainder = dividend;
		for (int i = maxTwoPower; i > -1; i--) {
			remainder -= (divisor << i);
			if (remainder >= 0) {
				ret += (1 << i);
			} else {
				remainder += (divisor << i);
			}
		}
		return ((dividend ^ divisor) >> 31) == 1 ? (-ret) : (ret);
	}
}
