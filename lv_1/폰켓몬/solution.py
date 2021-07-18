def solution(nums):
	kinds = []
	for i in nums:
		if i not in kinds:
			kinds.append(i)
	answer = len(nums) / 2
	if len(kinds) < answer:
		answer = len(kinds)
	return answer
