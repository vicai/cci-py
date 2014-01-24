def getPerm(s):
    result = []
    if(len(s)==1):
        result.append(s)
        return result
    for item in getPerm(s[:-1]):
        result.append(s[-1]+item)
        for i in xrange(len(item)-1):
            result.append(item[:i+1] + s[-1] + item[i+1:]) 
        result.append(item+s[-1])
    return result

def test():
    s = "abcd"
    print len(getPerm(s))

if __name__ == "__main__":
    test()
