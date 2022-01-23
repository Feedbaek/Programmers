import java.util.ArrayList;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int	day = 1;		// 날짜
		int cnt = 0;		// 기능 개수
		int len = progresses.length;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<len; i++) {
			if (progresses[i] + (speeds[i] * day) < 100) {
				list.add(cnt);		// 이전까지 카운트한 기능 개수 넣기
				cnt = 1;
				while (progresses[i] + (speeds[i] * day) < 100)
					day++;		// 날짜를 계속 증가
			}
			else
				cnt++;
		}
		list.add(cnt);
		int[] ret = new int[list.size() - 1];	// 시작하자마자 값을 넣으므로
		for (int i=0; i < list.size()-1; i++)	// 맨 앞의 값을 뺴고 대입
			ret[i] = list.get(i+1);
		return (ret);
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] progress = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		System.out.println(s.solution(progress, speeds));
	}
}
