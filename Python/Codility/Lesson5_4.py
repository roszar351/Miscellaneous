# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A, B, K):
    if B < A or K <= 0:
        raise Exception("Invalid Input")
 
    minValue =  ((A + K -1) // K) * K
 
    if minValue > B:
      return 0
 
    return ((B - minValue) // K) + 1
