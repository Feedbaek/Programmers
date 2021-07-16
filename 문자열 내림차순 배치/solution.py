def solution(s):
	return "".join(sorted(s, key= lambda s: s, reverse=True))
