def solution(s, n):
	answer = ''
	for ch in s:
		if ch.isupper():
			answer += chr(65 + (ord(ch) + n - 65) % 26)
		elif ch.islower():
			answer += chr(97 + (ord(ch) + n - 97) % 26)
		else:
			answer += ch
	return answer
