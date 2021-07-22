class Solution {
	public char rec_3(int n, char[] s, StringBuilder sum) {
		int x = n / 3;
		if (n % 3 == 0 && x > 0)
			x--;
		if (x > 0)
			sum.append(rec_3(x, s, sum));
		return (s[(n - 1)%3]);
	}
	public String solution(int n) {
		char s[] = {'1','2','4'};
		StringBuilder sb = new StringBuilder();
		sb.append(rec_3(n, s, sb));
		return (sb.toString());
	}
	public static void main(String[] args){
		Solution s = new Solution();
		String r = s.solution(10);
		System.out.println(r);
	}
}

// 다른 사람 코드

//class Solution {
//	public String solution(int n) {
//		String[] num = {"4","1","2"};
//		String answer = "";

//		while(n > 0){
//			answer = num[n % 3] + answer;
//			n = (n - 1) / 3;
//		}
//		return answer;
//	}
//}
