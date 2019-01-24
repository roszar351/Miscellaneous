## Binary search for sNum in ordered list of numbers numsList
def binary_search(numsList, sNum):
    middleNum = numsList[int(len(numsList) / 2)]

    if len(numsList) == 1:
        print("{}: {} in {}".format(sNum == middleNum, sNum, numsList))
        return sNum == middleNum
    elif sNum == middleNum:
        print("True: {} found in {}".format(sNum, numsList))
        return True
    elif sNum > middleNum:
        return binary_search(numsList[int(len(numsList) / 2):], sNum)
    else:
        return binary_search(numsList[:int(len(numsList) / 2)], sNum)

l = [2, 4, 6, 8, 10]
with open('file_to_save.txt', 'w') as open_file:
    open_file.write(str(binary_search(l, 5)) + "\n") # prints False
    open_file.write(str(binary_search(l, 10)) + "\n") # prints True
    open_file.write(str(binary_search(l, -1)) + "\n") # prints False
    open_file.write(str(binary_search(l, 2)) + "\n") # prints True
