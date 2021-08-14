import java.util.ArrayList;

class Solution {
	ArrayList<String> make_sub(String str) {	// 두 글자씩 끊어서 집합을 만듬
		String sub_str;

		ArrayList<String> sub_set = new ArrayList<String>();
		for (int i=0; i<str.length()-1; i++){
			sub_str = str.substring(i, i+2);
			if (Character.isAlphabetic(sub_str.charAt(0)) && Character.isAlphabetic(sub_str.charAt(1)))
				sub_set.add(sub_str);	// 만든 문자열중에 알파벳 아닌건 추가 안함
		}
		return sub_set;
	}

	public int solution(String str1, String str2) {
		double sum;
		double intersection = 0;
		ArrayList<String> sub_str1 = make_sub(str1);
		ArrayList<String> sub_str2 = make_sub(str2);

		for (int i=0; i<sub_str1.size(); i++)	// 합집합을 만들 때 sub_str1을 기준으로 비교함
			for (int j=0; j<sub_str2.size(); j++)
				if (sub_str1.get(i).equalsIgnoreCase(sub_str2.get(j))) {
					sub_str2.remove(j);	// sub_str2에 중복되는 값이 있으면 sub_str2에서 지움
					break;
				}
		sum = sub_str1.size() + sub_str2.size();
		if (sum == 0)	// 공집합의 합이면
			return 65536;
		sub_str2 = make_sub(str2);	// 지워지기 전으로 다시 만듬
		for (int i=0; i<sub_str1.size(); i++)	// 교집합을 만들 때 sub_str1을 기준으로 비교함
			for (int j=0; j<sub_str2.size(); j++)
				if (sub_str1.get(i).equalsIgnoreCase(sub_str2.get(j))) {
					sub_str2.remove(j);	// sub_str2에 중복되는 값이 있으면 sub_str2에서 지움
					intersection++;
					break;
				}
		return (int)((intersection/sum) * 65536);
	}

	void test(String str1, String str2, Solution s) {
		System.out.println(s.solution(str1, str2));
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test("FRANCE", "french", s);
		s.test("handshake", "shake hands", s);
		s.test("aa1+aa2", "AAAA12", s);
		s.test("E=M*C^2", "e=m*c^2", s);
	}
}
