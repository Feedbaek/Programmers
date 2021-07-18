def solution(x):
	if x % sum(list(map(int, list(str(x))))):
		return False
	return True
