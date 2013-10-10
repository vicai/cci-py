# 1
# 1 1
# 2 1
# 1 2 1 1
# 1 1 1 2 2 1
# 3 1 2 2 1 1

list0 = [1]
list1 = [1, 1]

def findList(prevList):
	count = 1
	prev = prevList[0]
	curList = []
	for num in prevList[1:]:
		if (prev == num):
			count+=1
			prev = num
		else:
			curList.append(count)
			curList.append(prev)
			prev = num
			count = 1
	curList.append(count)
	curList.append(prev)
	return curList

def printList(n):
	if n == 1:
		return [1,1]
	else:
		return findList(printList(n-1))
		n-=1

def look_and_say(member):
    while True:
        yield member
        breakpoints = ([0] + [i for i in range(1, len(member)) if member[i - 1] != member[i]] + [len(member)])
        groups = [member[breakpoints[i - 1]:breakpoints[i]]
                  for i in range(1, len(breakpoints))]
        member = ''.join(str(len(group)) + group[0] for group in groups)
 
# Print the 10-element sequence beginning with "1"
sequence = look_and_say("1")
for i in range(10):
    print sequence.next()
