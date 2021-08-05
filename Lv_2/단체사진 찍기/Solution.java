class Solution {
	static char[] screen = {'0', '0', '0', '0', '0', '0', '0', '0'};
	static char[] name = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static int ret = 0;

	static int searchIndex(char ch) {
		for (int i=0; i<8; i++)
			if (screen[i] == ch)
				return (i);
		return (-1);
	}

	static boolean validate(String condition) {
		char p1 = condition.charAt(0);
		char p2 = condition.charAt(2);
		char op = condition.charAt(3);
		int wall = condition.charAt(4) - 48;
		int gap = searchIndex(p1) - searchIndex(p2);

		if (gap < 0)
			gap *= -1;
		if (op == '=' && gap == wall+1)
				return (true);
		else if (op == '>' && gap > wall+1)
				return (true);
		else if (op == '<' && gap < wall+1)
				return (true);
		return (false);
	}

	static void rec(int r, int n, String[] data) {
		if (r == 8) {
			for (int i=0; i<n; i++)
				if (!validate(data[i]))
					return ;
			ret++;
		}
		else
			for (int i=0; i<8; i++)
				if (searchIndex(name[i]) == -1) {
					screen[r] = name[i];
					rec(r+1, n, data);
					screen[r] = '0';
				}
	}

	public int solution(int n, String[] data) {
		ret = 0;
		rec(0, n, data);
		return ret;
	}
	public static void main(String[] args) {
		String[] data1 = {"N~F=0", "R~T>2"};
		Solution s1 = new Solution();
		System.out.println("return: "+s1.solution(2, data1));
		String[] data2 = {"M~C<2", "C~M>1"};
		Solution s2 = new Solution();
		System.out.println("return: "+s2.solution(2, data2));
	}
}
