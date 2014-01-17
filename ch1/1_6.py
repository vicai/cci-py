def rotate(matrix):
    for layer in xrange(len(matrix)/2):
        first = layer
        last = len(matrix)-1-layer
        for i in xrange(first, last):
            offset = i-first
            print offset
            top = matrix[first][i]
            # left -> top
            matrix[first][i] = matrix[last-offset][first]
            # bottom -> top
            matrix[last-offset][first] = matrix[last][last-offset]
            #right->bottom
            matrix[last][last-offset] = matrix[i][last]
            #top -> right
            matrix[i][last] = top
    return matrix

def test():
    matrix = [[1,2,3,4,5],
                [6,7,8,9,10],
                [11,12,13,14,15],
                [16,17,18,19,20],
                [21,22,23,24,25]]
    print rotate(matrix)

if __name__=="__main__":
    test()
