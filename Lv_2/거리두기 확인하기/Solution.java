class Solution {
	int[][] map = new int[5][5];	// 경로 체크 배열

	boolean check_DFS(int r, int x, int y, String[] place) {
		if (r==2)		// 2번만 체크
			return (true);
		map[x][y] = r+1;	// 경로 체크
		if (x+1 < 5 && map[x+1][y] == 0 && place[x+1].charAt(y) != 'X')	// 파티션이 없는 첫 경로면
			if (place[x+1].charAt(y) == 'P' || !check_DFS(r+1, x+1, y, place))	// 거리 내에 사람체크
				return (false);			// 사람이 있으면 false
		if (x-1 >= 0 && map[x-1][y] == 0 && place[x-1].charAt(y) != 'X')
			if (place[x-1].charAt(y) == 'P' || !check_DFS(r+1, x-1, y, place))
				return (false);
		if (y+1 < 5 && map[x][y+1] == 0 && place[x].charAt(y+1) != 'X')
			if (place[x].charAt(y+1) == 'P' || !check_DFS(r+1, x, y+1, place))
				return (false);
		if (y-1 >= 0 && map[x][y-1] == 0 && place[x].charAt(y-1) != 'X')
			if (place[x].charAt(y-1) == 'P' || !check_DFS(r+1, x, y-1, place))
				return (false);
		return (true);
	}

	int check_BFS(String[] place) {
		for (int x=0; x<5; x++)
			for (int y=0; y<5; y++)
				if (place[x].charAt(y) == 'P') {	// 사람이 있으면 체크
					map = new int[5][5];	// 경로 배열 초기화
					if (!check_DFS(0, x, y, place))		// 거리두기 위반
						return (0);
				}
		return (1);
	}

	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int i=0; i<5; i++)
			answer[i] = check_BFS(places[i]);
		return answer;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] ret = s.solution(places);
		for (int i=0; i<5; i++)
			System.out.println(ret[i]);
	}
}
