def solution(n):
	answer = 0
	num = []
	while n > 0:
		num.append(n % 10)
		n //= 10
	num.sort(reverse=True)
	for nbr in num:
		answer *= 10
		answer += nbr
	return answer
