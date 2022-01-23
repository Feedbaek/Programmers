def solution(strings, n):
	strings.sort()
	n_str = []
	for word in strings:
		n_str.append(word[n])
	for i in range(len(strings) - 1):
		for j in range(len(strings) - 1 - i):
			if n_str[j] > n_str[j + 1]:
				n_str[j], n_str[j + 1] = n_str[j + 1], n_str[j]
				strings[j], strings[j + 1] = strings[j + 1], strings[j]
	return strings

'''
def solution(strings, n):
	strings.sort()
	return sorted(strings, key=lambda x: x[n])

'''
