class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        d = {}
        for i in xrange(len(num)):
            d[num[i]] = i+1
        for j in xrange(len(num)):
            left = target - num[j]
            if (d.has_key(left) and (j+1) < d[left]):
                return (j+1, d[left])