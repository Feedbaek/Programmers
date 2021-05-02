def solution(lottos, win_nums):
    answer = []
    max_value = 0
    min_value = 0
    for x in lottos:
        if x in win_nums:
            min_value += 1
        if x == 0:
            max_value += 1
    max_value += min_value
    answer.append((lambda x: 7 - x if x > 1 else 6)(max_value))
    answer.append((lambda x: 7 - x if x > 1 else 6)(min_value))
    return answer
