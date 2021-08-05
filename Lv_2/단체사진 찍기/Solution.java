class Solution {
	static char[] screen = {'0', '0', '0', '0', '0', '0', '0', '0'};	// 배치될 문자 배열
	static char[] name = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};	// 프렌즈 이름
	static int ret = 0;	// 결과 값 전역변수

	static int searchIndex(char ch) {	// 원하는 문자가 있는지 검사
		for (int i=0; i<8; i++)
			if (screen[i] == ch)	// 문자가 존재하면 해당 인덱스 반환
				return (i);
		return (-1);	// 없으면 -1을 리턴
	}

	static boolean validate(String condition) {	// 조건이 유효한지 검사
		char p1 = condition.charAt(0);
		char p2 = condition.charAt(2);
		char op = condition.charAt(3);
		int wall = condition.charAt(4) - 48;
		int gap = searchIndex(p1) - searchIndex(p2);	// 두 프렌즈 거리

		if (gap < 0)	// 거리 값이 음수면 양수로 변환
			gap *= -1;
		if (op == '=' && gap == wall+1)	// 조건을 만족하면 true
				return (true);
		else if (op == '>' && gap > wall+1)
				return (true);
		else if (op == '<' && gap < wall+1)
				return (true);
		return (false);	// 조건을 만족하지 않으면 false
	}

	static void rec(int r, int n, String[] data) {	// 재귀함수로 탐색
		if (r == 8) {	// 프렌즈가 모두 배치되면
			for (int i=0; i<n; i++)
				if (!validate(data[i]))	// 조건을 만족하지 않으면 종료
					return ;
			ret++;	// 만족하면 숫자 카운트
		}
		else	// 프렌즈를 문자 배열에 배치
			for (int i=0; i<8; i++)
				if (searchIndex(name[i]) == -1) {	// 중복검사
					screen[r] = name[i];	// 중복되지 않으면 배치
					rec(r+1, n, data);	// 다음 문자 배열 배치
					screen[r] = '0';	// 초기화
				}
	}

	public int solution(int n, String[] data) {
		ret = 0;	// 결과 값 전역변수 초기화
		rec(0, n, data);	// 재귀함수 시작
		return (ret);	// 결과 값 뱐환
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
