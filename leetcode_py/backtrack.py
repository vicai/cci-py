def backtrack(r, c, m, n):
	if (r==m and c==n):
		return 1
	if (r>m or c>n):
		return 0

	return backtrack(r+1, c, m, n) + backtrack(r, c+1, m, n) 

print backtrack(0, 0, 8, 10)