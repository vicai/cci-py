def reverse(x):
	if (x>0):
		x=str(x)
		y = int(x[-1::-1])
		return y
	elif (x==0): return x
	else:
		x=str(x)[1:]
		y = int(x[-1::-1])
		return -y

print reverse(100000000)
