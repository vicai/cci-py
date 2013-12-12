import math

def fib(n):
	root5 = math.sqrt(5)
	gr = (1+root5)/2
	igr = 1-gr
	value = (pow(gr, n)-pow(igr, n))/root5
	# round to a integer
	return math.floor(value+0.5)

def run():
	print fib(0)
	print fib(1)
	print fib(22)

run()
