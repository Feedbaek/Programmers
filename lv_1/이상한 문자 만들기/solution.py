def solution(s):
	answer = ''
	li = s.split(" ")
	for word in li:
		for i in range(len(word)):
			if i % 2 == 0:
				answer += word[i].upper()
			else :
				answer += word[i].lower()
		answer +=  " "
	return answer[:-1]

print(solution("try hello world"))
