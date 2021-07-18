def solution(s):
	p = 0
	y = 0
	s = s.lower()
	for ch in s:
		if ch == 'p':
			p += 1
		if ch == 'y':
			y += 1
	return p == y

'''
def solution(s):
	return s.lower().count('p') == s.lower().count('y')
'''
