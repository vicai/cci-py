def isUnique(myStr):
	if len(myStr) == 0: return False
	if len(myStr) == 1: return True
	for letter in myStr:
		for letter2 in myStr[myStr.find(letter)+1:]:
			if letter == letter2:
				return False
	return True

def test():
	assert(isUnique('a')==True)
	assert(isUnique('aa')==False)
	assert(isUnique('abc')==True)
	assert(isUnique('')==False)
	print "nail it!"

test()
