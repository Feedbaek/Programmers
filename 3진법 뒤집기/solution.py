def solution(n):
	seven = 0
	ten = 0
	while (n > 0):
		seven = (seven * 10) + n % 3
		n = n // 3
	rev = list(str(seven))
	rev_seven = int("".join(reversed(rev)))
	while (rev_seven > 0):
		ten = (ten * 3) + rev_seven % 10
		rev_seven = rev_seven // 10
	return ten
