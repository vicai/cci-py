package ch1;

public class oneToFive {
	public static void main(String[] args) {
		String s = repSpace("haha there is space");
		System.out.println(s);
	}

	public static String repSpace(String s) {
		char[] a = s.toCharArray();
		int length = a.length;
		int spaceCount = 0;
		for (char c : a) {
			if (c == ' ') {
				spaceCount++;
			}
		}
		char[] newA = new char[length + 2 * spaceCount];
		int count = 0;
		for (int i = 0; i < newA.length; ++i) {
			if (a[count] != ' ') {
				newA[i] = a[count];
			} else {
				newA[i] = '%';
				++i;
				newA[i] = '2';
				++i;
				newA[i] = '0';
			}
			++count; // bug place!!!
		}
		return new String(newA);
	}
}
