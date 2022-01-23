def solution(n):
	net = [1] * n	# 1로 채워진 크기 n의 리스트
	net[0] = 0		# 1을 소수가 아니다.
	for i in range(2, n):		# 따라서 2부터 n-1까지 비교
		for j in range(2, n):	# i의 2이상 배수는 소수가 아님
			if i * j > n:		# n-1까지 범위를 벗어나면 멈춤
				break
			net[i*j-1] = 0		# 소수가 아니므로 0 대입
	return sum(net)		# 모든 값을 더해서 개수를 구함
