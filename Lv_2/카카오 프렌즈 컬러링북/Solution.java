class Solution {
	int[][] map;	// 탐색 체크용 배열
	int size = 0;	// 영역 크기
	int width;		// 그림 가로 길이
	int height;		// 그림 세로 길이

	void parse(int x, int y, int elem, int[][] picture) {	// 영역 탐색
		if (map[x][y] != 0)	// 탐색한적 있으면 종료
			return ;
		size++;
		map[x][y] = 1;	// 탐색 체크표시
		if (x+1 < width && picture[x+1][y] == elem)	// 오른쪽 탐색
			parse(x+1, y, elem, picture);
		if (x-1 >= 0 && picture[x-1][y] == elem)	// 왼쪽 탐색
			parse(x-1, y, elem, picture);
		if (y+1 < height && picture[x][y+1] == elem)	// 위 탐색
			parse(x, y+1, elem, picture);
		if (y-1 >= 0 && picture[x][y-1] == elem)	// 아래 탐색
			parse(x, y-1, elem, picture);
	}

	public int[] solution(int m, int n, int[][] picture) {
		int number = 0;
		int maxsize= 0;
		width = m;
		height = n;
		map = new int[width][height];
		for (int x=0; x<width; x++) {	// 탐색
			for (int y=0; y<height; y++) {
				if (picture[x][y] != 0 && map[x][y] == 0) {
					size = 0;
					number++;
					parse(x, y, picture[x][y], picture);
					if (size > maxsize)	// 최대 크기 저장
						maxsize = size;
				}
			}
		}
		int[] answer = {number, maxsize};
		return answer;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int m = 6;
		int n = 4;
		int[] ret;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		ret = s.solution(m, n, picture);
		System.out.println("["+ret[0]+", "+ret[1]+"]");
	}
}
