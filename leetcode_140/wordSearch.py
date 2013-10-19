# wordSearch.py
# This code was developed in class on Tue 19-Feb-2013.
# As such, it may not contain perfect style, and may
# even contain a small bug here or there (usual disclaimer).

def wordSearch(board, word):
    (rows, cols) = (len(board), len(board[0]))
    for row in xrange(rows):
        for col in xrange(cols):
            result = wordSearchFromCell(board, word, row, col)
            if (result != None):
                return result
    return None

def wordSearchFromCell(board, word, startRow, startCol):
    for dir in xrange(8):
        result = wordSearchFromCellInDirection(board, word, startRow, startCol, dir)
        if (result != None):
            return result
    return None

def wordSearchFromCellInDirection(board, word, startRow, startCol, dir):
    (rows, cols) = (len(board), len(board[0]))
    dirs = [ (-1, -1), (-1, 0), (-1, +1),
             ( 0, -1),          ( 0, +1),
             (+1, -1), (+1, 0), (+1, +1) ]
    dirNames = [ "up-left", "up", "up-right",
                 "left"   ,       "right",
                 "down-left", "down", "down-right" ]
    (drow,dcol) = dirs[dir]    
    for i in xrange(len(word)):
        row = startRow + i*drow
        col = startCol + i*dcol
        if ((row < 0) or (row >= rows) or (col < 0) or (col >= cols) or
            (board[row][col] != word[i])):
            return None
    return (word, (startRow, startCol), dirNames[dir])

def testWordSearch():
    board = [ [ 'd', 'o', 'g' ],
              [ 't', 'a', 'c' ],
              [ 'o', 'a', 't' ],
              [ 'u', 'r', 'k' ],
            ]
    print wordSearch(board, "dog") # True
    print wordSearch(board, "cat") # True
    print wordSearch(board, "tad") # True
    print wordSearch(board, "cow") # False

testWordSearch()