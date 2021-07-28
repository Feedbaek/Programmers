import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		int cnt = 0;	// 횟수 변수
		int mix = 0;	// 섞인 음식
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for (int i=0; i < scoville.length; i++)	// 힙에 값 대입
			heap.add(scoville[i]);
		for (int x, y; heap.size() > 1;) {	// 요소는 최소 한개는 남깁니다.
			x = heap.poll();
			if (x >= K)		// 최소값이 K이상이면 멈춤
				break;
			y = heap.poll();
			mix = x + (y * 2);
			heap.add(mix);	// 섞어서 다시 넣음
			cnt++;		// 횟수 카운트
		}
		if (heap.poll() < K)	// 뽑은 요소가 K미만이면
			return (-1);
		return (cnt);
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] sco = {1,2,3,9,10,12};
		System.out.println(s.solution(sco, 7));
	}
}
