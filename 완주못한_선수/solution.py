def solution(participant, completion):
    answer = ''
    for i in range(len(participant)):
        flag = 0
        for j in range(len(completion)):
            if participant[i] == completion[j]:
                completion[j] = 0
                flag = 1
                break
        if flag == 0:
            answer = participant[i]
            break
    return answer