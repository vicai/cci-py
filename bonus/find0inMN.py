def findZero(matrix):
	m_row = len(matrix)
	n_col = len(matrix[0])
	zero_rows = []
	zero_cols = []
	for i in xrange(m_row):
		for j in xrange(n_col):
			if matrix[i][j] == 0:
				zero_rows.append(i)
				zero_cols.append(j)
	return zero_rows, zero_cols

def changeZero(matrix):
	zero_rows, zero_cols = findZero(matrix)
	m_row = len(matrix)
	n_col = len(matrix[0])
	for i in xrange(m_row):
		for j in xrange(n_col):
			if (i in zero_rows) or (j in zero_cols):
				matrix[i][j] = 0
	return matrix

def changeZero2(matrix):
	for 


def makeZero(matrix, i, j):
	for m in xrange(len(matrix[0])):
		matrix[i][m] = 0
	for n in xrange(len(matrix)):
		matrix[n][j] = 0



def run():
	m = [[1, 2, 3, 4, 5],
		 [2, 4, 5, 0, 7],
		 [3, 5, 6, 8, 1],
		 [2, 5, 3, 5, 1]
		 ]

	print changeZero2(m)

run()