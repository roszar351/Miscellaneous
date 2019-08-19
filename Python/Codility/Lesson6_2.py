# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
import sys

def solution(A):
    # write your code in Python 3.6
    A.sort()
    N = len(A)
    minusProd = A[0] * A[1] * A[N-1]
    plusProd = A[N-1] * A[N-2] * A[N-3]

    return plusProd if plusProd > minusProd else minusProd

def solution2(A):
    min1 = sys.maxsize
    min2 = sys.maxsize

    max1 = -sys.maxsize - 1
    max2 = -sys.maxsize - 1
    max3 = -sys.maxsize - 1

    for i in A:
        if i > max1:
            max3 = max2
            max2 = max1
            max1 = i
        elif i > max2:
            max3 = max2
            max2 = i
        elif i > max3:
            max3 = i
        
        if i < min1:
            min2 = min1
            min1 = i
        elif i < min2:
            min2 = i

    plusProd = max1 * max2 * max3
    minusProd = min1 * min2 * max1

    return plusProd if plusProd > minusProd else minusProd
