class Solution {
	char[] checkOp(String expression) {
		char[] op = new char[3];

		for (int i=0; i<expression.length(); i++) {
			if (expression.charAt(i) == '*')
				op[0] = '*';
			else if (expression.charAt(i) == '+')
				op[1] = '+';
			else if (expression.charAt(i) == '-')
				op[2] = '-';
			}
		return op;
	}

	int[] ft_atoi(String express) {
		int ret[] = {0, 0};

		for (int i=0; i<express.length(); i++) {
			if (Character.isDigit(express.charAt(i))) {
				ret[0] = i+1;
				ret[1] = (ret[1]*10) + express.charAt(i)-48;
			}
			else
				return (ret);
		}
		return (ret);
	}

	long cal(long x, long y, char op) {
		long sum = 0;

		if (op == '+')
			sum = x + y;
		else if (op == '-')
			sum = x - y;
		else
			sum = x * y;
		return (sum);
	}

	String ft_atoa(String express, char target) {
		String new_express = "";
		long x = 0;
		long y = 0;
		char op;

		for (int i=0; i<express.length(); i++) {
			for (int j=i; j<express.length(); j++) {
				if (Character.isDigit(express.charAt(j)))
					x = (x*10) + express.charAt(j)-48;
				else {
					i = j;
					break;
				}
			}
			op = express.charAt(i);
			if (op != target) {
				new_express += String.valueOf(x) + op;
				continue;
			}
			for (int j=i+1; j<express.length(); j++) {
				if (Character.isDigit(express.charAt(j)))
					y = (y*10) + express.charAt(j)-48;
				else {
					i = j-1;
					break;
				}
			}
			x = cal(x, y, op);
		}
		return new_express;
	}

	long rec_sum(String express, char op[]) {
		long x;
		long y;

		char op;

		x = ft_atoi(express)
	}

	public long solution(String expression) {
		long answer = 0;
		char[] op = checkOp(expression);
		return answer;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String expression = "100-200*300-500+20";
		System.out.print(s.solution(expression));
	}
}
