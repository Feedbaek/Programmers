def solution(n):
	seven = 0		# 7진법으로 바꾼 수를 담을 변수
	ten = 0			# 10진법으로 바꾼 수를 담을 변수
	while (n > 0):			# 자릿수를 높이며 3으로 나눈 나머지를 더함
		seven = (seven * 10) + n % 3
		n = n // 3
	rev = list(str(seven))			# 정수를 리스트로 바꿈
	rev_seven = int("".join(reversed(rev)))			# 리스트 값을 뒤집고 정수로 바꿈
	while (rev_seven > 0):			# 3진수를 다시 10진수로 바꿈
		ten = (ten * 3) + rev_seven % 10
		rev_seven = rev_seven // 10
	return ten
