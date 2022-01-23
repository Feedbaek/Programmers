class Solution {
	public long solution(long w, long h) {
		long cnt = 0;
		for (int i=0; i<w; i++)		// 가로 길이만큼 반복
			cnt += ((h * (i + 1) + w - 1) / w) - (h * i / w);	// 지워지는 사각형
		return ((w * h) - cnt);		// 전체 사각형 개수에서 뺸다
	}
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		Solution s = new Solution();
		System.out.println(s.solution(w, h));
	}
}
