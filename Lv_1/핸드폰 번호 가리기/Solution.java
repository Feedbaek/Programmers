class Solution {
	public String solution(String phone_number) {
		String answer = "";
		int num_len = phone_number.length();
		for (int i=0; i<num_len; i++) {
			if (i < num_len-4)
				answer += '*';
			else
				answer += phone_number.charAt(i);
		}
		return answer;
	}
}
