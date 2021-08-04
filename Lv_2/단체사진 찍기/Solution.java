class Solution {
	static char[] screen = {'0', '0', '0', '0', '0', '0', '0', '0'};
	static int ret = 0;

	static int factorial(int n) {
		if (n < 2)
			return (1);
		return (n * factorial(n-1));
	}

	static int searchInScreen(char ch) {
		for (int i=0; i<8; i++) {
			if (screen[i] == ch) {
				return (i);
			}
		}
		return (-1);
	}

	static void equal(int idx, int n, int x1, String[] data) {
		int where;
		int x;

		if (x1 == 0)
			x = 2;
		else
			x = 0;
		where = searchInScreen(data[n].charAt(x));
		if (where != -1) {
			if (idx+1 == where) {
				rec(n-1, data);
			}
		}
		else {
			if (idx+1 < 8 && screen[idx+1] == '0') {
				screen[idx+1] =  data[n].charAt(x);
				rec(n-1, data);
				screen[idx+1] = '0';
			}
		}
	}

	static void more(int idx, int n, int x1, String[] data) {
		int where;
		int x;

		if (x1 == 0)
			x = 2;
		else
			x = 0;
		where = searchInScreen(data[n].charAt(x));
		if (where != -1) {
			if (idx < where && idx+2 <= where) {
				rec(n-1, data);
			}
		}
		else {
			for (; idx+2< 8; idx++) {
				if (screen[idx+2] == '0') {
					screen[idx+2] =  data[n].charAt(x);
					rec(n-1, data);
					screen[idx+2] = '0';
				}
			}
		}
	}

	static void less(int idx, int k, int n, int x1, String[] data) {
		int where;
		int x;

		if (x1 == 0)
			x = 2;
		else
			x = 0;
		where = searchInScreen(data[n].charAt(x));
		if (where != -1) {
			if (idx < where && idx+k >= where) {
				rec(n-1, data);
			}
		}
		else {
			for (int i=0; i < k; i++) {
				if (idx+i < 8 && screen[idx+i]== '0') {
					screen[idx+i] =  data[n].charAt(x);
					rec(n-1, data);
					screen[idx+i] = '0';
				}
			}
		}
	}

	static void rec(int n, String[] data) {
		int k, where;

		if (n < 0) {
			int cnt = 0;
			for (int i=0; i<8; i++)
				if (screen[i] == '0')
					cnt++;
			ret += factorial(cnt);
			System.out.println(screen);
			return ;
		}
		k = data[n].charAt(4) - 48;
		for (int x1=0; x1 < 3; x1+=2) {
			where = searchInScreen(data[n].charAt(x1));
			if (where != -1) {
				if (data[n].charAt(3) == '=') {
					equal(where + k, n, x1, data);
				}
				else if (data[n].charAt(3) == '>') {
					more(where + k, n, x1, data);
				}
				else {
					less(where, k, n, x1, data);
				}

			}
			else {
				for (int i=0; i < 8; i++) {
					if (screen[i] != '0')
						continue;
					screen[i] = data[n].charAt(x1);
					if (data[n].charAt(3) == '=') {
						equal(i + k, n, x1, data);
					}
					else if (data[n].charAt(3) == '>') {
						more(i + k, n, x1, data);
					}
					else {
						less(i, k, n, x1, data);
					}
					screen[i] = '0';
				}
			}
		}
	}
	public int solution(int n, String[] data) {
		for (int i=0; i<8; i++)
			screen[i] = '0';
		ret = 0;
		rec(n-1, data);
		return ret;
	}
	public static void main(String[] args) {
		int n = 2;
		String[] data1 = {"N~F=0", "R~T>2"};
		Solution s1 = new Solution();
		System.out.println("return: "+s1.solution(n, data1));
		String[] data2 = {"M~C<2", "C~M>1"};
		Solution s2 = new Solution();
		System.out.println("return: "+s2.solution(n, data2));
	}
}
