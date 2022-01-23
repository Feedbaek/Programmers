class Solution {
	int ret = 0;	// 결과 값 전역변수
	void rec(int n, int sum, int[] numbers, int target) {
		if (n == numbers.length) {	// 끝에 도달하면
			if (sum == target)	// 타겟과 일치하는지 검사
				ret++;
			return ;
		}
		rec(n+1, sum + numbers[n], numbers, target);	// 더하기 계산
		rec(n+1, sum - numbers[n], numbers, target);	// 빼기 계산
	}

	public int solution(int[] numbers, int target) {
		rec(0, 0, numbers, target);
		return ret;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(s.solution(numbers, target));
	}
}
