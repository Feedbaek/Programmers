def solution(N, stages):
	answer = []
	start = [0] * (N + 1)
	ing = [0] * (N + 1)
	for i in stages:
		ing[i - 1] += 1
		for j in range(i):
			start[j] += 1

	print(start)
	print(ing)

	return answer
