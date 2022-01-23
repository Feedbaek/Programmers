def solution(new_id):
    new_id = new_id.lower()
    answer = ''
    for x in range(len(new_id)):
        if new_id[x].isalnum() or new_id[x] in "-_.":
            answer += new_id[x]
        answer = answer.replace("..", '.')
    if answer[0] == '.':
        answer = answer[1:]
    if len(answer) > 0 and answer[-1] == '.':
        answer = answer[:-1]
    if answer == '':
        answer = 'a'
    if len(answer) > 15:
        answer = answer[:15]
    if answer[-1] == '.':
        answer = answer[:-1]
    while (len(answer) < 3):
        answer = answer + answer[-1]
    return answer
