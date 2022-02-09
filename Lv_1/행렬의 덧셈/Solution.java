class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = {};
		int height = arr1.length;
		int width = arr1[0].length;
		answer = new int[height][width];
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] arr1 = {{1,2},{2,3}};
		int[][] arr2 = {{3,4},{5,6}};
		int[][] ret = s.solution(arr1, arr2);
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				System.out.print(ret[i][j]);
			}
			System.out.println();
		}
	}
}
