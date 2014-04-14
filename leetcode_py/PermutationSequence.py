import math

def getPermutation(n, k):
    left = [i for i in range(1,n+1)]
    result = ""
    for j in xrange(1, n):
        index = k/math.factorial(n-j)
        k = k%math.factorial(n-j)
        if(k==0 and index!=0): 
            index-=1
            k = math.factorial(n-j)
        result+=str(left.pop(index))
    result+=str(left.pop(0))
    return result

def test():
    print getPermutation(3,6)

test()
