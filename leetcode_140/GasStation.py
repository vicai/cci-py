def gasStation(gas, cost):
    total, count, target=[0, 0, 0]
    n=len(gas)
    for i in xrange(n):
        total+=gas[i]-cost[i]
        count+=gas[i]-cost[i]
        if(total<0):
            total=0;
            target=(i+1)%n
    if(count<0): return -1
    return target

def test():
    print gasStation([1,2,3,4,5], [3,4,5,1,2])
    print gasStation([2],[2])

test()
