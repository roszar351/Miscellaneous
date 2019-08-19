# Could also use xor operator to find solution in O(n) time

def solution(A):
    # write your code in Python 3.6
    answer = 0
    A.sort()
    N = len(A)
    i = 0
    
    while i < N:
        if i == N - 1:
            answer = A[i]
            break
        elif A[i] != A[i + 1]:
            answer = A[i]
            break

        i += 2
    
    return answer
    
# First attempt poor performance
# def solution(A):
#     # write your code in Python 3.6
#     answer = 0
#     N = len(A)
#     i = 0
    
#     while i < N:
#         j = 0
#         while j < N:
#             # Found a pair
#             if j != i and A[i] == A[j]:
#                 j = N
#             elif j == N - 1:
#                 answer = A[i]
#                 i = N

#             j += 1

#         i += 1
    
#     return answer
