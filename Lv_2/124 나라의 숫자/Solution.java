class Solution {
	public char rec_3(int n, char[] s, StringBuilder sum) {		// 재귀함수
		int x = n / 3;		// 몫을 구한다
		if (n % 3 == 0)		// 자릿수가 처음 바뀔 때는
			x--;		// 자릿수를 바꾸지 않는다
		if (x > 0)		// 몫이 있으면 재귀함수 호출
			sum.append(rec_3(x, s, sum));		// 반환되는 문자를 추가
		return (s[n % 3]);		// 자릿수가 바뀌는 시점에 0대신 4가 들어감
	}
	public String solution(int n) {
		char s[] = {'4','1','2'};
		StringBuilder sb = new StringBuilder();		// 스트링빌더 선언
		sb.append(rec_3(n, s, sb));		// 재귀함수로 계속 문자 추가
		return (sb.toString());		// 문자열 반환
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
