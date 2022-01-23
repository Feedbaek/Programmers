def solution(arr1, arr2):
	for i in range(len(arr1)):
		for j in range(len(arr1[0])):
			arr2[i][j] += arr1[i][j]
	return arr2

'''
def sumMatrix(A,B):
    answer = [[c + d for c, d in zip(a, b)] for a, b in zip(A,B)]
    return answer
'''
