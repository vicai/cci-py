import math

def fib(n):
	root5 = math.sqrt(5)
	gr = (1+root5)/2
	igr = 1-gr
	value = (pow(gr, n)-pow(igr, n))/root5
	# round to a integer
	return math.floor(value+0.5)

def fib2(n):
    if(n<=1) return n;
    a = b;
    b = fib2(n-1)
    return a+b

def run():
	print fib2(0)
	print fib2(1)
	print fib2(22)

run()
