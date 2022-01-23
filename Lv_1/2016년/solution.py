def solution(a, b):
    answer = ''
    day = b % 7 - 1
    firstDay = ["FRI", "MON", "TUE", "FRI", "SUN",
                "WED", "FRI", "MON", "THU", "SAT", "TUE", "THU"]
    array = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
    answer = firstDay[a - 1]
    for idx in range(len(array)):
        if array[idx] == answer:
            day = (idx + day) % 7
            answer = array[day]
            break
    return answer
