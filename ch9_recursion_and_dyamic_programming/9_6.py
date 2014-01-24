def generateParens(n):
    result = []
    s = ""
    result = help(n, n, result, s)
    return result

# construct a tree by the left right number of parenthese!!
def help(left, right, result, s):
    if(left==0 and right==0):
        result.append(s)
        return result
    else:
        if(left>0):
            help(left-1, right, result, s+"(")
        if(left<right):
            help(left, right-1, result, s+")")
        return result

def test():
    print generateParens(3)

if __name__ == "__main__":
    test()
