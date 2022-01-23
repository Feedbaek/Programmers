class Solution {
	Boolean in_arr(int num, int[] arr) {	// 배열에 숫자가 있는지 확인
		for (int i=0; i<arr.length; i++)
			if (arr[i] == num)
				return true;
		return false;
	}

	public int[] solution(String s) {	// 집합의 원소 개수 오름차순으로 중복없이 배열에 넣음
		String[] str = s.split("}");
		int n = str.length;
		int[] answer = new int[n];

		for (int i=0, idx=0; i<s.length() && idx < n; i++) {
			if (Character.isDigit(s.charAt(i))) {
				int cnt = 0;
				int end_idx = s.indexOf("}",i);
				for (int j=i; j<end_idx; j++)	// 원소 개수 체크
					if (s.charAt(j) == ',')
						cnt++;
				if (cnt != idx) {	// 개수가 맞지 않는다면 계속 진행
					i=end_idx;
					continue;
				}
				for (int j=i; j<end_idx; j++) {	// 개수가 맞는다면 배열에 넣고 처음부터 반복
					int comm_idx = s.indexOf(",", j);
					if (comm_idx == -1)
						comm_idx = end_idx;
					int num = Integer.parseInt(s.substring(j, comm_idx < end_idx ? comm_idx : end_idx));
					if (!in_arr(num, answer))
						answer[idx++] = num;
					j = comm_idx;
				}
				i = -1;		// 처음부터 탐색
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println("===================");
		String str = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] ret = s.solution(str);
		for (int i=0; i <ret.length; i++) {
			System.out.print(ret[i]+" ");
		}
		System.out.println("");
		System.out.println("===================");
		str = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		ret = s.solution(str);
		for (int i=0; i <ret.length; i++) {
			System.out.print(ret[i]+" ");
		}
		System.out.println("");
		System.out.println("===================");
		str = "{{20,111},{111}}";
		ret = s.solution(str);
		for (int i=0; i <ret.length; i++) {
			System.out.print(ret[i]+" ");
		}
		System.out.println("");
		System.out.println("===================");
		str = "{{123}}";
		ret = s.solution(str);
		for (int i=0; i <ret.length; i++) {
			System.out.print(ret[i]+" ");
		}
		System.out.println("");
		System.out.println("===================");
		str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		ret = s.solution(str);
		for (int i=0; i <ret.length; i++) {
			System.out.print(ret[i]+" ");
		}
		System.out.println("");
		System.out.println("===================");
	}
}
