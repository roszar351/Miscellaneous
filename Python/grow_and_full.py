import random

functionSet = ['+', '-', '*', '/']
terminalSet = [str(i) for i in range(0, 10)]
terminalSet.append('X')
answerSet = []

def full(depth, currentDepth):
    if currentDepth == depth:
        answerSet.append(terminalSet[random.randint(0, len(terminalSet) - 1)])

    if currentDepth < depth:
        answerSet.append(functionSet[random.randint(0, len(functionSet) - 1)])
        full(depth, currentDepth + 1)
        full(depth, currentDepth + 1)

    return

def grow(depth, currentDepth):
    if currentDepth == depth:
        answerSet.append(terminalSet[random.randint(0, len(terminalSet) - 1)])

    if currentDepth < depth:
        whichSet = random.randint(0, 1)

        if whichSet == 0:
            answerSet.append(functionSet[random.randint(0, len(functionSet) - 1)])
            grow(depth, currentDepth + 1)
            grow(depth, currentDepth + 1)
        else:
            answerSet.append(terminalSet[random.randint(0, len(terminalSet) - 1)])

    return
      
full(3, 0)
print(answerSet)
