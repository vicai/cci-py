def getPath(x, y):
    if(x<0 or y<0): return 0
    if(x==0 and y==0): return 1
    return (getPath(x, y-1) if isFree(x,y-1) else 0)+\
            (getPath(x-1, y) if isFree(x-1,y) else 0)

def getPath2(x, y, paths):
    #paths.append((x,y))
    if(x==0 and y==0): return True
    success = False
    
    if(x>=1 and isFree(x-1, y)):
        # go left
        success = getPath2(x-1, y, paths)
    if(not success and y>=1 and isFree(x, y-1)):
        success = getPath2(x,y-1,paths)
    if(success):
        paths.append((x,y))
    print paths
    return success


def getPathDP(x, y, paths, cache):
    if((x,y) in cache):
        return cache[(x,y)]
    if(x==0 and y==0):
        return True

    success = False
    if(x>=1 and isFree(x-1, y)):
        # go left
        success = getPathDP(x-1, y, paths, cache)
    if(not success and y>=1 and isFree(x, y-1)):
        success = getPathDP(x,y-1,paths, cache)
    if(success):
        paths.append((x,y))
    cache[(x,y)] = success
    return success


def isFree(x,y):
    if(x==2 and y==2): return False
    return True

def test():
    print getPath(2,3)
    print getPath2(2,3,[])
    print getPathDP(2,3,[],{})

if __name__=="__main__":
    test()
