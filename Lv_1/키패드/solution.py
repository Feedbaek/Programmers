def solution(numbers, hand):
	answer = ''
	l_loc = 10
	r_loc = 12
	for i in numbers:
		l_mov = 0
		l_dif = 0
		r_mov = 0
		r_dif = 0
		if i == 1 or i == 4 or i == 7:
			l_loc = i
			answer += 'L'
			continue
		if i == 3 or i == 6 or i == 9:
			r_loc = i
			answer += 'R'
			continue
		if (i == 0):
			i = 11
		l_dif = abs(l_loc - i)
		while (l_dif > 2):
			l_mov += 1
			l_dif -= 3
		while (l_dif > 0):
			l_mov += 1
			l_dif -= 1
		r_dif = abs(r_loc - i)
		while (r_dif > 2):
			r_mov += 1
			r_dif -= 3
		while (r_dif > 0):
			r_mov += 1
			r_dif -= 1
		if l_mov < r_mov or (l_mov == r_mov and hand == "left"):
			l_loc = i
			answer += 'L'
		else:
			r_loc = i
			answer += 'R'
	return answer
