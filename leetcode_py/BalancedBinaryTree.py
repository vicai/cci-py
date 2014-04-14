class TreeNode(object):
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right

def maxDepth(root):
    if(root==None): return 0
    leftHeight = maxDepth(root.left)
    rightHeight = maxDepth(root.right)
    return leftHeight+1 if (leftHeight>rightHeight) else (rightHeight+1)

def minDepth(root):
    if(root==None): return 0
    if(root.left==None and root.right==None): return 1
    return __findMin(root, 1)

def __findMin(root, depth):
    if(root==None): return depth-1

    leftDepth = __findMin(root.left, depth+1)
    rightDepth = __findMin(root.right, depth+1)
    if(leftDepth==depth): return rightDepth
    if(rightDepth==depth): return leftDepth

    return leftDepth if (leftDepth<rightDepth) else rightDepth

def isBalanced(root):
    if(root==None): return True
    val = __getBalance(root)
    if(val==-1): return False
    return True

def __getBalance(root):
    if(root==None): return 0
    left = __getBalance(root.left)
    if(left==-1): return -1
    right = __getBalance(root.right)
    if(right==-1): return -1
    print "right, left:"+str(right)+str(left)
    if(left-right>1 or right-left>1):
        return -1
    return left+1 if left>right else right+1

def main():
    root = TreeNode(1, 
            TreeNode(2, TreeNode(3, TreeNode(4, None, None), None), None),
            TreeNode(2, None, TreeNode(3, None, TreeNode(4, None, None)))
        )
    print maxDepth(root), minDepth(root), isBalanced(root)

if __name__=="__main__":
    main()
