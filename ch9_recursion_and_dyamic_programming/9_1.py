def countWay(n):
    if(n==0): return 1
    if(n==1): return 1
    if(n==2): return 2
    if(n==3): return 4
    return countWay(n-1)+countWay(n-2)+countWay(n-3)

def countWay2(n):
    if(n<0):
        return 0
    elif(n==0):
        return 1
    else:
        return countWay2(n-1)+countWay2(n-2)+countWay2(n-3)

def countWay3(n, result):
    if(n<0):
        return 0
    elif(n==0):
        return 1
    elif(result[n]>-1):
        return result[n]
    else:
        result[n] = countWay3(n-1, result)+countWay3(n-2, result)+countWay3(n-3, result)
        return result[n]

def test():
    assert(countWay(0)==countWay2(0))
    assert(countWay(15)==countWay2(15))
    # length has to be large enough
    result = [-1 for i in xrange(100)]
    print countWay3(13, result)
    print countWay2(3)
    print("passed!")

if __name__=="__main__":
    test()
