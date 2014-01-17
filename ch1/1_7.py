def setZeroes(matrix):
    rownum = len(matrix)
    colnum = len(matrix[0])

    hasZeroFirstRow = False
    hasZeroFirstCol = False

    for j in xrange(colnum):
        if(matrix[0][j]==0):
            hasZeroFirstRow = True

    for i in xrange(rownum):
        if(matrix[i][0]==0):
            hasZeroFirstCol = True

    for i in xrange(1, len(matrix)):
        for j in xrange(1, len(matrix[0])):
            if(matrix[i][j]==0):
                matrix[i][0] = 0
                matrix[0][j] = 0

    for i in xrange(1, len(matrix)):
        for j in xrange(1, len(matrix[0])):
            if(matrix[i][0] == 0 or matrix[0][j]==0):
                matrix[i][j]

    if hasZeroFirstRow:
        for j in xrange(colnum):
            matrix[0][j] = 0

    if hasZeroFirstCol:
        for i in xrange(rownum):
            matrix[i][0] = 0
