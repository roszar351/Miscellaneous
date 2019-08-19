# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    N = len(A)
    A.sort()
    
    for i in range(0, N):
        if A[i] != i+1:
            return 0

    return 1
