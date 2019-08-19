# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    N = len(A)
    rightTape = 0
    leftTape = 0
    tempSum = 0
    answer = 0

    for i in A:
        tempSum += i

    for P in range(1, N):
        leftTape += A[P - 1]
        rightTape = tempSum - leftTape
        
        if P == 1:
            answer = abs(leftTape - rightTape)
        else:
            temp = abs(leftTape - rightTape)
            if temp < answer:
                answer = temp
    
    return answer
