def paintFill(screen, x, y, ocolor, ncolor):
    if(x<0 || x>=len(screen)) || y<0 || y>=len(screen[0]):
        return False;
    elif (screen[x][y] == ocolor):
        screen[x][y] = ncolor
        paintFill(screen, x+1, y, ocolor, ncolor)
        paintFill(screen, x-1, y, ocolor, ncolor)
        paintFill(screen, x, y+1, ocolor, ncolor)
        paintFill(screen, x, y-1, ocolor, ncolor)
    return True;

def test():
    # 省略一万字。。。

if __name__=="__main__":
    test()
