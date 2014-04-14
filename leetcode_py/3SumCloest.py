class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        if(len(num)==1): return num[0]
        if(len(num)==2): return num[0]+num[1]
        num.sort()
        minDiff = abs(num[0]+num[1]+num[2] - target)
        minSum = num[0]+num[1]+num[2]
        for i in xrange(len(num)-2):
            head = i+1;
            tail = len(num)-1;
            while(head<tail):
                mySum = num[i]+num[head]+num[tail]
                diff = mySum-target
                if(diff==0):
                    return target
                elif(diff > 0):
                    tail-=1
                else:
                    head+=1
                if(abs(diff)<minDiff):
                    minSum = mySum
                    minDiff = abs(diff)
        return minSum    
