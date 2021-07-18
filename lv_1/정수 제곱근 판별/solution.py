def solution(n):
	r = int(n**0.5)
	if r**2 == n :
		return (r + 1)**2
	else:
		return -1
