import java.util.ArrayList;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int	day = 1;
		int cnt = 0;
		int len = progresses.length;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<len; i++) {
			if (progresses[i] + (speeds[i] * day) < 100) {
				list.add(cnt);
				cnt = 1;
				while (progresses[i] + (speeds[i] * day) < 100)
					day++;
			}
			else
				cnt++;
		}
		list.add(cnt);
		int[] ret = new int[list.size() - 1];
		for (int i=0; i < list.size()-1; i++)
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
