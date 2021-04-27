def solution(participant, completion):
    answer = ''
    a = {}
    for pa in participant:
        if pa in a.keys():
            a[pa] += 1
        else:
            a[pa] = 0
    for cp in completion:
        if a[cp] == 0:
            del a[cp]
        else:
            a[cp] -= 1
    return list(a.keys())[0]
