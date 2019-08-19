# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    answer = 0
    N = len(A) + 1
    for i in A:
        answer += i

    answer = ((N * (N + 1)) // 2) - answer

    return answer