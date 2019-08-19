# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(X, A):
    # write your code in Python 3.6
    answer = -1
    requiredLeaves = {i+1 for i in range(0, X)}
    currentLeaves = set()
    #print(requiredLeaves)

    for i in range(0, len(A)):
        if A[i] <= X:
            currentLeaves.add(A[i])
        if len(currentLeaves) == len(requiredLeaves):
            answer = i
            break

    return answer

print(solution(5, [1, 3, 1, 4, 2, 3, 5, 4]))
    