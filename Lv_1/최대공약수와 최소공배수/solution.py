def solution(n, m):
	answer = [0] * 2
	for i in range(1, n + 1):
		if n % i == 0 and m % i == 0:
			answer[0] = i
	for i in range(m, n * m + 1):
		if i % n == 0 and i % m == 0:
			answer[1] = i
			return answer
