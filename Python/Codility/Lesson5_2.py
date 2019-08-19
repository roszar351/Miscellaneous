# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S, P, Q):
    # write your code in Python 3.6
    answer = []
    minFactor = 0
    
    for i in range(len(P)):
        minFactor = getValueOfFactor(S[P[i]])
        if minFactor == 1:
            answer.append(minFactor)
        else:
            for j in range(P[i], Q[i]+1):
                if getValueOfFactor(S[j]) < minFactor:
                    minFactor = getValueOfFactor(S[j])
                if minFactor == 1:
                    break

            answer.append(minFactor)
                

    
    return answer

def getValueOfFactor(c):
    if c == 'A':
        return 1
    elif c == 'C':
        return 2
    elif c == 'G':
        return 3

    return 4
    
def solution2(S, P, Q):
    values = {}
    values['A'] = 1
    values['C'] = 2
    values['G'] = 3
    values['T'] = 4
    answer = []
    allSums = [[0 for i in range(len(S)+1)] for i in range(4)]

    for i in range(len(S)):
        value = values[S[i]]
        a = 0 
        c = 0
        g = 0
        if value == 1:
            a = 1
        elif value == 2:
            c = 1
        elif value == 3:
            g = 1

        allSums[0][i+1] = allSums[0][i] + a
        allSums[1][i+1] = allSums[1][i] + c
        allSums[2][i+1] = allSums[2][i] + g

    for i in range(len(P)):
        fromInd = P[i]
        toInd = Q[i] + 1

        if allSums[0][toInd] - allSums[0][fromInd] > 0:
            answer.append(1)
        elif allSums[1][toInd] - allSums[1][fromInd] > 0:
            answer.append(2)
        elif allSums[2][toInd] - allSums[2][fromInd] > 0:
            answer.append(3)
        else:
            answer.append(4)

    return answer
