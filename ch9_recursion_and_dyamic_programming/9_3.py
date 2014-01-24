def magicSlow(array):
    for i in xrange(len(array)):
        if(array[i]==i):
            return i
    return -1

# use binary search with distinct sorted array
def magicFast(array):
    return help(array, 0, len(array)-1)

def help(array, head, tail):
    if(head>tail): return -1
    mid = (tail-head)/2+head
    if(array[mid] == mid): return mid
    elif (array[mid]<mid):
        return help(array, mid+1, tail)
    else:
        return help(array, head, mid-1)

# use binary search both side for the non distinct sorted array

def magicFast2(array):
    return help2(array, 0, len(array)-1)

def help2(array, head, tail):
    if(head>tail): return -1

    mid = (tail-head)/2+head;
    if(array[mid] == mid): return mid
    else:
        nextTail = min(array[mid], mid-1)
        nextHead = max(array[mid], mid+1)
    if(help2(array, head, nextTail)==-1):
        return help2(array, nextHead, tail)
    else:
        return help2(array, head, nextTail) 

def test():
    array = [1,2,3,4,5,6,6,7]
    print magicSlow(array)
    array = [-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13]
    print magicFast(array)
    array = [-10, -5, 2,2,2,3,4,7,9,12,13]
    print magicFast2(array)

if __name__=="__main__":
    test()
