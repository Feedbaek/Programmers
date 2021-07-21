import java.util.Arrays;

class Solution {
	public int solution(String s) {
		int len = s.length();
		int answer[];
		answer =  new int[len];
		for (int i = 1; i < len + 1; i++) {
			String ret = "";
			for (int j = 0; j < len;) {
				int cnt = 1;
				String str = "";
				if (j + i < len) {
					str = s.substring(j, j + i);
					while (j+(i*(cnt + 1)-1) < len && str.equals(s.substring(j + (i * (cnt)), j + (i*(cnt+1))))){
						cnt += 1;
					}
					if (cnt > 1) {
						ret += String.valueOf(cnt);
					}
					ret += str;
				}
				else {
					str = s.substring(j);
					ret += str;
				}
				j += cnt * i;
			}
			answer[i - 1] = ret.length();
		}
		Arrays.sort(answer);
		return answer[0];
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int n = s.solution("xababcdcdababcdcd");
		System.out.println(n);
	}
}
