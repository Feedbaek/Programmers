from math import sqrt


def is_prime(nbr):
    if nbr == 0 or nbr == 1:
        return 0
    if nbr == 2:
        return 1
    for x in range(2, int(sqrt(nbr)) + 1):
        if nbr % x == 0:
            return 0
    return 1


def solution(nums):
    answer = 0
    for first in range(len(nums) - 2):
        for second in range(first + 1, len(nums) - 1):
            for third in range(second + 1, len(nums)):
                answer += is_prime(nums[first] + nums[second] + nums[third])
    return answer
