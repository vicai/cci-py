def isAnagram(strA, strB):
    strC = ''.join(sorted(strA))
    strD = ''.join(sorted(strB))
    return strC==strD

def isAnagram2(strA, strB):
    allStr = [0 for i in xrange(256)]
    if(len(strA)!=len(strB)): return False
    for i in xrange(len(strA)):
        allStr[ord(strA[i])]+=1
        allStr[ord(strB[i])]-=1
    for i in xrange(256):
        if(allStr[i] != 0):
            return False
    return True

def test():
    assert(True==isAnagram("aaabbb", "ababab"))
    assert(True==isAnagram("", ""))
    assert(False==isAnagram("a", "aa"))
    print "nail 1!"
    assert(True==isAnagram2("aaabbb", "ababab"))
    assert(True==isAnagram2("", ""))
    assert(False==isAnagram2("a", "aa"))
    print "nail 2!"


if __name__ == "__main__":
    test()
