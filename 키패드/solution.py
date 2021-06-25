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
			if i == 1:
				l_loc = 1
			elif i == 4:
				l_loc = 4
			else:
				l_loc = 7
			answer += 'L'
			continue
		if i == 3 or i == 6 or i == 9:
			if i == 3:
				r_loc = 3
			elif i == 6:
				r_loc = 6
			else:
				r_loc = 9
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
			if i == 2:
				l_loc = 2
			elif i == 5:
				l_loc = 5
			elif i == 8:
				l_loc = 8
			else:
				l_loc = 11
			answer += 'L'
		else:
			if i == 2:
				r_loc = 2
			elif i == 5:
				r_loc = 5
			elif i == 8:
				r_loc = 8
			else:
				r_loc = 11
			answer += 'R'
	return answer
