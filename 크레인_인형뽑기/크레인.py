def solution(board, moves):
    answer = 0
    basket = []
    for grap_column in moves:
        for index in range(len(board)):
            if (board[index][grap_column - 1] != 0):
                basket.append(board[index][grap_column - 1])
                board[index][grap_column - 1] = 0
                break
    flag = 1
    while (flag == 1):
        for i in range(len(basket) - 1):
            if basket[i] == basket[i + 1]:
                answer += 2
                del basket[i + 1]
                del basket[i]
                flag = 0
                break
        flag += 1
    return answer


b = [[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [
    0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]]
mv = [1, 5, 3, 5, 1, 2, 1, 4]
print(solution(b, mv))
