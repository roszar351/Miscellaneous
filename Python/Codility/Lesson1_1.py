# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# longest binary gap
def solution(N):
    # write your code in Python 3.6
    binVer = format(N, 'b')
    longest = 0
    sequence = False
    counter = 0
    print("Binary version of ", N, ": ", binVer)

    i = 0

    while i < len(binVer):
        if binVer[i] == '1' and not sequence:
            sequence = True
        elif binVer[i] == '1':
            if counter > longest:
                longest = counter
            sequence = False
            counter = 0
            i -= 1
        elif sequence:
            counter += 1
        i += 1

    return longest