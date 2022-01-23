import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public String[] solution(String[] record) {
		Map<String, String> profile = new HashMap<String, String>();	// 아이디 맵 변수
		ArrayList<String> answer = new ArrayList<String>();	// 관리자가 볼 문자열 배열리스트
		for (int i=0; i<record.length; i++) {
			String[] split = record[i].split(" ");	// 공백을 기준으로 문자열을 나눔
			if (!split[0].equals("Leave"))	// Enter, Change의 경우
				profile.put(split[1], split[2]);	// 맵의 키를 아이디로 닉네임을 저장
		}
		for (int i=0; i<record.length; i++) {
			String[] split = record[i].split(" ");
			if (split[0].equals("Enter"))	// 입장의 경우
				answer.add(profile.get(split[1]) + "님이 들어왔습니다.");	// 맵의 value와 합쳐서 추가
			else if (split[0].equals("Leave"))	// 퇴장의 경우
				answer.add(profile.get(split[1]) + "님이 나갔습니다.");	// 맵의 value와 합쳐서 추가
		}
		return answer.toArray(new String[answer.size()]);	// 배열리스트를 배열로 바꿈
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] ret;
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		ret = s.solution(record);
		for (int i=0; i<ret.length; i++)
			System.out.println(ret[i]);
	}
}
