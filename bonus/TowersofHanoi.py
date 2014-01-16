def TowersofHanoi(n, frm, to, via):
    if(n<=1): 
        print (n, frm, to)
    else:
        TowersofHanoi(n-1, frm, via, to)
        TowersofHanoi(1, frm, to, via)
        TowersofHanoi(n-1, via, to, frm)

def test():
    TowersofHanoi(3, 0, 1, 2) 

if __name__ == "__main__":
    test()
