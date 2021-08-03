class Solution {
	static char[] screen = {'0', '0', '0', '0', '0', '0', '0', '0'};
	static int ret = 0;

	static int factorial(int n) {
		if (n < 2)
			return (1);
		return (n * factorial(n-1));
	}
	static void equal(int idx, int k, int n, String[] data) {
		if (idx+k+1 < 8 && screen[idx+k+1] == '0') {
			screen[idx+k+1] =  data[n].charAt(2);
			rec(n-1, data);
			screen[idx+k+1] = '0';
		}
	}
	static void more(int idx, int k, int n, String[] data) {
		for (; idx+k+2< 8; k++) {
			if (screen[idx+k+2] == '0') {
				screen[idx+k+2] =  data[n].charAt(2);
				rec(n-1, data);
				screen[idx+k+2] = '0';
			}
		}
	}
	static void less(int idx, int k, int n, String[] data) {
		for (int i=0; i < k; i++) {
			if (idx+i+2 < 8 && screen[idx+i+2]== '0') {
				screen[idx+i+2] =  data[n].charAt(2);
				rec(n-1, data);
				screen[idx+i+2] = '0';
			}
		}
	}

	static int searchInScreen(char ch) {
		for (int i=0; i<8; i++) {
			if (screen[i] == ch)
				return (i);
		}
		return (0);
	}

	static void rec(int n, String[] data) {
		int k, idx;
		System.out.println("n: "+n);
		if (n < 0) {
			int cnt = 0;
			for (int i=0; i<8; i++)
				if (screen[i] == '0')
					cnt++;
			ret += factorial(cnt);
			System.out.println("ret: "+ret);
			System.out.println(screen);
			return ;
		}
		k = data[n].charAt(4) - 48;
		idx = searchInScreen(data[n].charAt(0));
		if (idx != 0) {

		}
		for (int i=0; i < 8; i++) {
			if (screen[i] != '0')
				continue;
			screen[i] = data[n].charAt(0);
			if (data[n].charAt(3) == '=') {
				System.out.println("equal, k: "+k);
				equal(i, k, n, data);
			}
			else if (data[n].charAt(3) == '>') {
				System.out.println("more, k: "+k);
				more(i, k, n, data);
			}
			else {
				System.out.println("less, k: "+k);
				less(i, k, n, data);
			}
			screen[i] = '0';
		}
	}
	static String[] validate(int n, String[] data) {
		String[] new_data;
			if
		return (new_data);
	}

	public int solution(int n, String[] data) {
		rec(n-1, data);
		return (int)Math.pow(2, n)*ret;
	}
	public static void main(String[] args) {
		int n = 2;
		String[] data1 = {"N~F=0", "R~T>2"};
		Solution s1 = new Solution();
		System.out.println("return: "+s1.solution(n, data1));
		//ret = 0;
		//String[] data2 = {"M~C<2", "C~M>1"};
		//Solution s2 = new Solution();
		//System.out.println("return: "+s2.solution(n-1, data2));
	}
}
