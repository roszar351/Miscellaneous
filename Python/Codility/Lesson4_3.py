# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(N, A):
    # write your code in Python 3.6
    counters = [0 for i in range(N)]
    maxVal = 0
    
    for i in A:
        if i > N:
            counters = [maxVal for i in range(N)]
        else:
            counters[i-1] += 1
            if counters[i-1] > maxVal:
                maxVal = counters[i-1]

    return counters

def solution2(N, A):
    # write your code in Python 3.6
    counters = [0 for i in range(N)]
    maxVal = 0
    current_max = 0
    
    for i in A:
        if 1 <= i <= N:
            if maxVal > counters[i-1]:
                counters[i-1] = maxVal
            counters[i-1] += 1
            if current_max < counters[i-1]:
                current_max = counters[i-1]
        else:
            maxVal = current_max
    
    for i in range(0, N):
        if counters[i] < maxVal:
            counters[i] = maxVal

    return counters

print(solution(5, [2, 3, 6]))
