def olution(array, commands):
    answer = []
    tmp = []
    for n in range(len(commands)):
        tmp = array[commands[n][0] - 1:commands[n][1]]
        tmp.sort()
        answer.append(tmp[commands[n][2] - 1])
    return answer
