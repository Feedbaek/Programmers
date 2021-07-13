def solution(s):
	str = ""
	idx = 0
	number = {'zero':'0', 'one':'1', 'two':'2', 'three':'3', 'four':'4', 'five':'5', 'six':'6', 'seven':'7', 'eight':'8', 'nine':'9'}
	while idx < len(s):
		if s[idx] in "0123456789":
			str += s[idx]
			idx += 1
		else:
			length = idx
			while length < len(s):
				if s[idx:length] not in number:
					length += 1
				else:
					break
			str += number[s[idx:length]]
			idx = length
	return int(str)
