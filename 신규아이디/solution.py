import re


def is_valid(answer):
    answer = answer.lower()
    for ch in answer:
        if (ch.isalnum()):
            continue
        answer = re.sub(ch, "", answer)
    return answer


def solution(new_id):
    answer = ''
    answer = is_valid(new_id)

    print(answer)
    return answer


solution("123+ @-AAASD")
