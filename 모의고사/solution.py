def solution(answers):
    answer = []
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    person = {1: 0, 2: 0, 3: 0}
    for idx in range(len(answers)):
        if p1[idx % 5] == answers[idx]:
            person[1] += 1
        if p2[idx % 8] == answers[idx]:
            person[2] += 1
        if p3[idx % 10] == answers[idx]:
            person[3] += 1
    m = max(person.values())
    for p in person.keys():
        if person[p] == m:
            answer.append(p)
    return answer
