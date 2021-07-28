def solution(n, lost, reserve):
    answer = n - len(lost)    # 체육복을 안 잃어버린 사람 카운트
    for idx in range(len(lost)):    # 도난 당했지만 여벌 체육복이 있는 사람 카운트
        for res in range(len(reserve)):
            if lost[idx] == reserve[res]:
                answer += 1
                lost[idx] = -1
                reserve[res] = -1
                break
    for idx in range(len(lost)):    # 도난 당하고 다른사람 체육복 빌리는 사람 카운트
        for res in range(len(reserve)):
            if lost[idx] == reserve[res] - 1 or lost[idx] == reserve[res] + 1:
                answer += 1
                lost[idx] = -1
                reserve[res] = -1
                break
    return answer
