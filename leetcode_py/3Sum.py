class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        num.sort()
        result = []
        for i in xrange(0, len(num)-2):
            if(num[i] > 0): break
            if(i>0 and num[i-1]==num[i]): continue
            head = i+1
            tail = len(num)-1
            target = -num[i]
            while(head < tail):
                print (num[i], num[head], num[tail])
                mySum = num[i]+num[head]+num[tail]
                if(mySum > 0):
                    tail-=1
                elif(mySum < 0):
                    head+=1
                else:
                    result.append([num[i], num[head], num[tail]])
                    head+=1
                    tail-=1
                    while (head>0 and head<tail):
                        if(num[head]==num[head-1]): head+=1
                        else: break
                    while (tail<len(num)-1 and head<tail):
                        if(num[tail]==num[tail+1]): tail-=1
                        else: break
        return result
