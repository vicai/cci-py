def reverseCstr(myCStr):
	return myCStr[-2::-1]+'\x00'

def test():
	assert(reverseCstr('abc\0')=='cba\0')
	assert(reverseCstr('a\0')=='a\0')
	print 'nail it!'

test()