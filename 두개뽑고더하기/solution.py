def solution(numbers):
    answer = []
    for idx in range(len(numbers) - 1):
        for i in range(idx + 1, len(numbers)):
            if numbers[idx] + numbers[i] not in answer:
                answer.append(numbers[idx] + numbers[i])
    answer.sort()
    return answer
