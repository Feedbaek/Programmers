class Solution {
	public long solution(long w, long h) {
		long cnt = 0;
		for (int i=0; i<w; i++)
			cnt += ((h * (i + 1) + w - 1) / w) - (h * i / w);
		return ((w * h) - cnt);
	}
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		Solution s = new Solution();
		System.out.println(s.solution(w, h));
	}
}
