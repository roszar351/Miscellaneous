# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    answer = 0
    zerosPassed = 0

    for i in A:
        if i == 0:
           zerosPassed += 1
        else:
            answer += zerosPassed
            if answer > 1000000000:
                return -1

    return answer