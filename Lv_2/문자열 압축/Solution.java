import java.util.Arrays;

class Solution {
	public int solution(String s) {
		int len = s.length();		// 문자열 총 길이
		int answer[] =  new int[len];		// 압축 문자열 길이를 담을 배열
		for (int i = 1; i < len + 1; i++) {		// 압축 문자열 길이
			String ret = "";		// 압축 문자열 만들기
			for (int j = 0; j < len;) {		// 크기 i 단위로 압축하기
				int cnt = 1;		// 반복되는 문자열 개수
				String str = "";		// 크기 i만큼 나눈 문자열 버퍼
				if (j + i < len) {		// 크기 i만큼 나눌수 있으면
					str = s.substring(j, j + i);		// i부터 j-1까지 자르기
					while (j+(i*(cnt + 1)-1) < len &&
					str.equals(s.substring(j + (i * (cnt)), j + (i*(cnt+1)))))
							// 중복되는 문자열이 있으면 반복
						cnt += 1;		// 중복 개수 카운트
					if (cnt > 1)		// 중복이 존재하면
						ret += String.valueOf(cnt);		// 문자열에  중복표시
					ret += str;			// 압축 문자열에 버퍼크기의 문자 추가
				}
				else {		// 나머지 문자열
					str = s.substring(j);
					ret += str;		// 압축 문자열에 추가
				}
				j += cnt * i;		// 중복 문자열 크기 포함해서 인덱스 이동
			}
			answer[i - 1] = ret.length();		// 리스트에 문자열 길이 대입
		}
		Arrays.sort(answer);		// 오름차순 정렬
		return answer[0];		// 가장 작은 값 반환
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int n = s.solution("xababcdcdababcdcd");
		System.out.println(n);
	}
}
