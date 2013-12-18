class Node(object):
    def __init__(self, value, next=None):
        self.value=value
        self.next=next

def RemoveNthNodeFromEndofList(head, n):
    faster = head;
    slower = head;
    while(n!=0):
        faster = faster.next
        n-=1;
    while(faster.next!=None and slower.next!=None):
        faster = faster.next
        slower = slower.next
    slower.next = slower.next.next
    return head

def printLinkedList(head):
    listString = ""
    pointer = head;
    while(pointer!=None):
        listString+=(str(pointer.value)+'-->')
        pointer = pointer.next
    return listString

def test():
    e = Node(5, None)
    d = Node(4, e)
    c = Node(3, d)
    b = Node(2, c)
    a = Node(1, b)
    print printLinkedList(RemoveNthNodeFromEndofList(a, 2))
     
test()
