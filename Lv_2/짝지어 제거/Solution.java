class Solution {
	public int solution(String str)
	{
		int len = str.length();		// 문자열 길이
		char[] s = new char[len];	// 문자열 스택 만들기
		int idx = 0;		// 스택 인덱스
		for (int i=0; i < len; i++) {	// 문자열 탐색
			if (idx > 0 && s[idx - 1] == str.charAt(i))
				idx--;		// 인덱스가 1이상이고 이전 인덱스 값과 같은 문자면 인덱스 감소
			else
				s[idx++] = str.charAt(i);		// 이전 인덱스 값과 다르면 스택에 추가
		}
		if (idx == 0)		// 스택 인덱스가 0이면 비어있다는 뜻
			return (1);
		return (0);
	}
	public static void main (String[] args){
		Solution s = new Solution();
		System.out.println(s.solution("baabaa"));
	}
}
