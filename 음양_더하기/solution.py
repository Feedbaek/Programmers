def solution(absolutes, signs):
    answer = 0
    for idx in range(len(absolutes)):
        if signs[idx] == False:
            absolutes[idx] *= -1
        answer += absolutes[idx]
    return answer
