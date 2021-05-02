def solution(s):
    answer = ''
    idx = len(s) // 2
    if len(s) % 2 == 0:
        answer += s[idx - 1]
    answer += s[idx]
    return answer
