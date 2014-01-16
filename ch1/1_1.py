def isUnique(myStr):
    if len(myStr) == 0: return False
    if len(myStr) == 1: return True
    for letter in myStr:
	for letter2 in myStr[myStr.find(letter)+1:]:
	    if letter == letter2:
		return False
    return True

def isUnique2(myStr):
    allStr = [0 for i in xrange(8)]
    for i in xrange(len(myStr)):
        index = ord(myStr[i])/32
        shift = ord(myStr[i])%32
        if(allStr[index] & (1<<shift)): return False
        allStr[index] |= (1<<shift)
    return True


def test():
	assert(isUnique('a')==True)
	assert(isUnique('aa')==False)
	assert(isUnique('abc')==True)
	assert(isUnique('')==False)
	print "nail it 1!"
        assert(isUnique2('a')==True)
	assert(isUnique2('aa')==False)
	assert(isUnique2('abc')==True)
	assert(isUnique2('')==True)
        assert(isUnique2("abcdefghijklmnopqrstuvwxyzABCD1234567890")==True)
	print "nail it 2!"


if __name__=="__main__":
    test()
