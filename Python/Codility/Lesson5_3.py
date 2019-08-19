# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    answer = 0
    minValue = len(A) * 2
 
    for i in range(len(A)-1):
        if (A[i] + A[i+1])/2.0 < minValue:
            answer = i
            minValue = (A[i] + A[i+1])/2.0
        if i < len(A)-2 and (A[i] + A[i+1] + A[i+2])/3.0 < minValue:
            answer = i
            minValue = (A[i] + A[i+1] + A[i+2])/3.0
 
    return answer