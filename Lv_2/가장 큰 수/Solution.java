class Solution {
	void buble_sort(String[] numbers) {	// 버블 정렬함수
		String tmp;

		for (int i=0; i<numbers.length-1; i++)
			for (int j=0; j<numbers.length-1-i; j++)
				for (int idx=0;;) {	// 두 문자열의 앞글자 비교
					if (numbers[j].charAt(idx) < numbers[j+1].charAt(idx)) {	// 뒷 문자열이 크다면 위치 바꿈
						tmp = numbers[j];
						numbers[j] = numbers[j+1];
						numbers[j+1] = tmp;
						break;
					}
					else if (numbers[j].charAt(idx) == numbers[j+1].charAt(idx)) {
						if (idx+1 == numbers[j].length() || idx+1 == numbers[j+1].length()) {
							if (numbers[j].length() < numbers[j+1].length()) {
								if (numbers[j].charAt(0) < numbers[j+1].charAt(idx+1)) {
									tmp = numbers[j];
									numbers[j] = numbers[j+1];
									numbers[j+1] = tmp;
								}
							}
							else if (numbers[j].length() > numbers[j+1].length()) {
								if (numbers[j].charAt(idx+1) < numbers[j+1].charAt(0)) {
									tmp = numbers[j];
									numbers[j] = numbers[j+1];
									numbers[j+1] = tmp;
								}
							}
							break;
						}	// 두 문자열이 같으면 통과
						idx++;							// 인덱스를 증가시킴
						// 문자열의 앞 문자가 같으면 다음 문자를 비교하기 위해
					}
					else	// 뒤 문자열이 크다면 통과
						break;
				}
	}

	public String solution(int[] numbers) {
		StringBuilder answer = new StringBuilder();
		String[] str_num = new String[numbers.length];
		int max = 0;

		for (int i=0; i<numbers.length; i++) {	// 문자열 배열을 만들어서 값을 넣어줌
			str_num[i] = String.valueOf(numbers[i]);
			if (max < numbers[i])
				max = numbers[i];
		}
		if (max == 0)
			return "0";
		buble_sort(str_num);	// 버블 정렬
		for (int i=0; i<str_num.length; i++)	// 오름차순 정렬이므로 내림차순으로 바꿈
			answer.append(str_num[i]);
		return answer.toString();
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {40, 403}));
		System.out.println(s.solution(new int[] {30, 3, 34, 5, 9}));
	}
}
