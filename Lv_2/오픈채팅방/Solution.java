import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public String[] solution(String[] record) {
		Map<String, String> profile = new HashMap<String, String>();
		ArrayList<String> answer = new ArrayList<String>();
		for (int i=0; i<record.length; i++) {
			String[] split = record[i].split(" ");
			if (!split[0].equals("Leave"))
				profile.put(split[1], split[2]);
		}
		for (int i=0; i<record.length; i++) {
			String[] split = record[i].split(" ");
			if (split[0].equals("Enter"))
				answer.add(profile.get(split[1]) + "님이 들어왔습니다.");
			else if (split[0].equals("Leave"))
				answer.add(profile.get(split[1]) + "님이 나갔습니다.");
		}
		return answer.toArray(new String[answer.size()]);
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
