def searchMatrix(matrix, target):
    height = len(matrix)
    width = len(matrix[0])
    for i in xrange(1, height):
        if(target<matrix[i][0]):
            for j in xrange(width):
                if (matrix[i-1][j]==target):
                    return True
    return False

def main():
    matrix = [[1, 3, 5, 7 ],
            [10, 11, 16, 20],
            [23, 30, 34, 50]]

    print searchMatrix(matrix, 3)

if __name__=="__main__":
    main()
