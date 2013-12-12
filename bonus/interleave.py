def interLeave(l1, l2):
	if(len(l1)==1 & len(l2)==1):
		l1.append(l2[0])
		return l1
	else:
		return [l1[0]]+[l2[0]]+interLeave(l1[1:], l2[1:])

print interLeave([1,2,3], [4,5,6])
