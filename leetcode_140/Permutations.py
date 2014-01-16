# algorithm is to insert frist element into each slot between the permtation of left elements

def permute(nums):
    if(len(nums)==1):
        return [nums]
    else:
        allPerms = []
        for subPerm in permute(nums[1:]):
            for i in xrange(len(subPerm)+1):
                allPerms += [subPerm[:i]+[nums[0]]+subPerm[i:]]
        return allPerms

def main():
    print permute([1,2,3])

if __name__ == "__main__":
    main()
