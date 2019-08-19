# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(X, Y, D):
    # write your code in Python 3.6
    answer = 0
    while X < Y:
        X += D
        answer += 1

    return answer

def solution2(X, Y, D):
    answer = Y - X
    if answer % D == 0:
        answer = answer // D
    else:
        answer = answer // D + 1

    return answer