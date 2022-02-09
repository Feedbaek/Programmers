class Solution {
	public long[] solution(int x, int n) {
		long[] answer = {};
		answer = new long[n];
		long sum = x;
		for (int r=0; r<n; r++) {
			answer[r] = sum;
			sum += x;
		}
		return answer;
	}
	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		long[] answer;
		Solution s = new Solution();
		answer = s.solution(x, n);
		for (int i=0; i<n; i++) {
			System.out.println(answer[i]);
		}
	}
}
