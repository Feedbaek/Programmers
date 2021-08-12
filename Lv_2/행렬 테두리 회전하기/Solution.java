class Solution {
	int[][] matrix;		// 행렬 변수

	int curl(int x1, int y1, int x2, int y2) {
		int x1y2 = matrix[x1][y2];	// 덮어씌워지는 부분
		int min = 10000;	// 최솟값은 10000 이하

		for (int i=y2; i>y1; i--) {		// 행렬 윗 부분 회전
			if (matrix[x1][i] < min)	// 최솟값 구하기
				min = matrix[x1][i];
			matrix[x1][i] = matrix[x1][i-1];
		}
		for (int i=x1; i<x2; i++) {		//행렬 왼쪽 부분 회전
			if (matrix[i][y1] < min)
				min = matrix[i][y1];
			matrix[i][y1] = matrix[i+1][y1];
		}
		for (int i=y1; i<y2; i++) {		// 행렬 아랫 부분 회전
			if (matrix[x2][i] < min)
				min = matrix[x2][i];
			matrix[x2][i] = matrix[x2][i+1];
		}
		for (int i=x2; i>x1; i--) {		// 행렬 오른쪽 부분 회전
			if (matrix[i][y2] < min)
				min = matrix[i][y2];
			matrix[i][y2] = matrix[i-1][y2];
		}
		matrix[x1+1][y2] = x1y2;		// 덮어씌워진 부분 복구
		return min;		// 최솟값 반환
	}

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		matrix = new int[rows][columns];

		for (int i=0; i<rows; i++)		// 행렬에 초기 값 대입
			for (int j=0; j<columns; j++)
				matrix[i][j] = j+1 + columns * i;
		for (int i=0; i<queries.length; i++)	// 회전
			answer[i] = curl(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
		return answer;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] ret = s.solution(rows, columns, queries);
		for (int i=0; i<queries.length; i++)
			System.out.println(ret[i]);
	}
}

// 1. 행렬 만들기
// 2. curl로 새로운 행렬을 만들기
// 3. 만들면서 최솟값을 찾기
// 4. 새로운 행렬로 반복
