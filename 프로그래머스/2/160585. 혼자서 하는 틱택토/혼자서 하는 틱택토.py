from collections import Counter


def solution(board):
    counter = Counter(''.join(board))
    valid = counter['O'] - counter['X']
    new_board = list(zip(*board))
    line_O = 0
    line_X = 0
    
    if valid not in [0,1]:
        return 0
    
    for i in range(3):
        if board[i].count('O') == 3 or new_board[i].count('O') == 3:
            line_O += 1
        if board[i].count('X') == 3 or new_board[i].count('X') == 3:
            line_X += 1
    
    for i in range(0,3,2):
        if board[0][i] == board[1][1] == board[2][2-i] == 'O':
            line_O += 1
        if board[0][i] == board[1][1] == board[2][2-i] == 'X':
            line_X += 1
    
    if line_O and line_X:
        return 0
    if line_O == 1 and valid == 0:
        return 0
    if line_X == 1 and valid == 1:
        return 0
    
    return 1
