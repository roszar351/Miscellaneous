# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# rotate/shift elements of A K to the right 
def solution(A, K):
    # write your code in Python 3.6
    N = len(A)
    result = [0 for i in range(N)]
    print("Rotating ", A, " by ", K)
    for i in range(N):
        print((i+K) % N)
        result[(i + K) % N] = A[i]
    print("Result ", result)

    return result

solution([1, 2, 3], 2)