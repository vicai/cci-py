def longestConsecutive(num):
    length = len(num)
    numDict = {}
    if (length==0): return 0
    else: 
        maxCount = 1
        positive = True
    for integer in num:
        numDict[integer] = True
    for interger in num:
        if(numDict[integer+1]=True)

def main():
    num = [100, 4, 200, 1, 3, 2]
    print longestConsecutive(num)

if __name__=="__main__":
    main()
