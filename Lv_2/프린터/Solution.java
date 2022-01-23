import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Integer> queue = new LinkedList<>();	// 큐를 만든다.
		Queue<Integer> order = new LinkedList<>();	//초기 인덱스를 저장하는 큐
		Integer prior[] = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
		Arrays.sort(prior, Collections.reverseOrder());	// 중요도가 높은 순서로 배열을 만든다.

		for (int i=0; i<priorities.length; i++)	// 큐에 값을 순서대로 넣어준다.
			queue.add(priorities[i]);
		for (int i=0; i<priorities.length; i++)	// 초기 인덱스를 저장
			order.add(i);
		for (int data=queue.poll(), idx=order.poll(); data!=0; data=queue.poll(), idx=order.poll()) {
			if (data != prior[answer]) {	// 우선순위가 맞지 않으면
				queue.add(data);	// 다시 큐의 뒤에 넣는다.
				order.add(idx);
			}
			else {
				answer++;	// 우선순위가 맞는다면 카운트
				if (idx == location)	// 원하는 위치를 뽑았으면 종료
					break;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		System.out.println(s.solution(priorities, location));
	}
}
