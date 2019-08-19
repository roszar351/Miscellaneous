# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    #A.sort()
    answer = 0

    for i in range(1, len(A) + 2):
        if i not in A:
            answer = i
            break

    return answer

def solution2(A):
    # write your code in Python 3.6
    seen = [False] * len(A)

    for i in A:
        if 0 < i <= len(A):
            seen[i-1] = True
    for i in range(0, len(seen)):
        if not seen[i]:
            return i + 1 

    return len(A) + 1