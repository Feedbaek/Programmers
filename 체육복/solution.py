def solution(n, lost, reserve):
    answer = n - len(lost)
    for idx in range(len(lost)):
        for res in range(len(reserve)):
            if lost[idx] == reserve[res]:
                answer += 1
                lost[idx] = -1
                reserve[res] = -1
                break
    for idx in range(len(lost)):
        for res in range(len(reserve)):
            if lost[idx] == reserve[res] - 1 or lost[idx] == reserve[res] + 1:
                answer += 1
                lost[idx] = -1
                reserve[res] = -1
                break
    return answer
