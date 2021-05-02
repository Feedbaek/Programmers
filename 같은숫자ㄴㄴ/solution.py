def solution(arr):
    answer = []
    for word in arr:
        if answer[-1:] == [word]:
            continue
        answer.append(word)
    return answer
