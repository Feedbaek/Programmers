def solution(answers):
    nswer = []
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    score = [0, 0, 0]
    for idx in range(len(answers)):
        if p1[idx % 5] == answers[idx]:
            score[0] += 1
        if p2[idx % 8] == answers[idx]:
            score[1] += 1
        if p3[idx % 10] == answers[idx]:
            score[2] += 1
    max_score = max(score)
    for p in range(len(score)):
        if score[p] == max_score:
            answer.append(p + 1)
    return answer
