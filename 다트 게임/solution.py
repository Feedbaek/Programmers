def solution(dartResult):
	score = [0] * 3		# 점수를 담을 리스트
	i = -1
	for idx in range(len(dartResult)):
		if dartResult[idx].isdigit():		# 만약 숫자면
			if idx > 0 and dartResult[idx - 1] == '1':		# 숫자가 10이면
				score[i] *= 10
			else :		# 숫자가 10이 아니면
				i += 1
				score[i] = int(dartResult[idx])
		elif dartResult[idx] == 'D':	# 옵션 'D'
			score[i] = score[i]**2
		elif dartResult[idx] == 'T':	# 옵션 'T'
			score[i] = score[i]**3
		elif dartResult[idx] == '*':	# 보너스 '*'
			score[i] *= 2
			if i > 0:		# 이전 점수가 있으면
				score[i - 1] *= 2
		elif dartResult[idx] == '#':	# 점수 마이너스
			score[i] *= -1
	return sum(score)
