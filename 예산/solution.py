def solution(d, budget):
    answer = 0
    sum = 0
    d.sort()
    for x in d:
        if sum + x > budget:
            break
        sum += x
        answer += 1
    return answer
