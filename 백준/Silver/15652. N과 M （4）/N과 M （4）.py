N, M = map(int, input().split())
path = [0] * M

def abc(level):
    if level==M:
        for i in path:
            print(i, end=" ")
        print()
        return
    for i in range(N):
        if level==0:
            path[level] = i+1
            abc(level+1)
        else:
            if i+1>=path[level-1]:
                path[level] = i+1
                abc(level+1)

abc(0)