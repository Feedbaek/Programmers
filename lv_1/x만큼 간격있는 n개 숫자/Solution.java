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
}
