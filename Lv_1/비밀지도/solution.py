def solution(n, arr1, arr2):
	answer = []
	for i in range(n):
		str = ""
		ret = arr1[i] | arr2[i]		# 비트 연산자 사용
		cnt = 0
		while cnt < n:		# 지도 크기 n만큼 수행
			if ret % 2 == 1:		# 일의 자릿수가 2로 나누어떨어지지 않으면
				str = '#' + str		# '#' 추가
			else :
				str = ' ' + str		# 나누어떨어지면 ' ' 공백 추가
			ret //= 2		# 다음 자릿수로 이동
			cnt += 1
		answer.append(str)		# 문자열 추가
	return answer
