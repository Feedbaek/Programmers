class Solution {
	int avg(int[][] scores, int j) {
		int min = 100;
		int max = 0;
		int sum = 0;

		for (int i=0; i<scores.length; i++) {
			if (i == j)
				continue ;
			if (scores[i][j] < min)
				min = scores[i][j];
			if (scores[i][j] > max)
				max = scores[i][j];
			sum += scores[i][j];
		}
		if (scores[j][j] < min || scores[j][j] > max)
			return (sum / (scores.length-1));
		return ((sum+scores[j][j]) / scores.length);
	}

	public String solution(int[][] scores) {
		String answer = "";
		int ret;

		for (int j=0; j<scores.length; j++) {
			ret = avg(scores, j);
			if (ret < 50)
				answer += 'F';
			else if (ret < 70)
				answer += 'D';
			else if (ret < 80)
				answer += 'C';
			else if (ret < 90)
				answer += 'B';
			else
				answer += 'A';
		}
		return answer;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] scores1 = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
		int[][] scores2 = {{50,90},{50,87}};
		int[][] scores3 = {{70,49,90},{68,50,38},{73,31,100}};

		System.out.println(s.solution(scores1));
		System.out.println(s.solution(scores2));
		System.out.println(s.solution(scores3));
	}
}

// 4 8 10 12 15 16 19
