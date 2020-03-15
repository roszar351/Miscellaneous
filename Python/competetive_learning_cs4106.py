# sample 2D points to be classified
sampleData = [[1.0,1.0], [9.4, 6.4], [2.5, 2.1], [8.0, 7.7], [0.5, 2.2], [7.9, 8.4], [7.0, 7.0], [2.8, 0.8], [1.2, 3.0], [7.8, 6.1]]

# initial weight vecotrs (not normalised)
nodeA = [7.0, 2.0]
nodeB = [2.0, 9.0]

# training the Kohonen layer
for i in range(0, len(sampleData)):
    print(sampleData[i])
    eucDisA = (sampleData[i][0] - nodeA[0]) ** 2 + (sampleData[i][1] - nodeA[1]) ** 2
    eucDisB = (sampleData[i][0] - nodeB[0]) ** 2 + (sampleData[i][1] - nodeB[1]) ** 2

    print("Node A({}): {} vs Node B({}): {}".format(nodeA, eucDisA, nodeB, eucDisB))
    if eucDisA < eucDisB:
        nodeA = [nodeA[0] + 0.5 * (sampleData[i][0] - nodeA[0]), nodeA[1] + 0.5 * (sampleData[i][1] - nodeA[1])]
        print("Node A won and becomes {}".format(nodeA))
    else:
        nodeB = [nodeB[0] + 0.5 * (sampleData[i][0] - nodeB[0]), nodeB[0] + 0.5 * (sampleData[i][0] - nodeB[0])]
        print("Node B won and becomes {}".format(nodeB))
