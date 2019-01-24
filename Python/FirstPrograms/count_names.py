with open('names.txt', 'r') as oF:
    line = oF.readline()
    num_of_names = {}

    while line:
        line = line.strip()
        if line in num_of_names:
            num_of_names[line] = num_of_names[line] + 1
        else:
            num_of_names[line] = 1
        line = oF.readline()

    print(num_of_names)
    names = [key for key in num_of_names]
    count = [value for value in num_of_names.values()]
    print(names)
    print(count)
