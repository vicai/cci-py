def removeDup(myStr):
	for char1 in xrange(0, len(myStr)-1):
		print char1
		for char2 in xrange(char1+1,len(myStr)):
			if myStr[char1] == myStr[char2]:
				myStr = myStr.replace(myStr[char2], "")
	return myStr

def test():
	print removeDup('abcabc')
	assert(removeDup('abcabc') == 'abc')
	assert(removeDup('abc') == 'abc')
	assert(removeDup('a') == 'a')
	print "nail it!"

test()
