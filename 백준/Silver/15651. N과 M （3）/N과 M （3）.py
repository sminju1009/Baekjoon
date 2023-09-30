N, M = map(int, input().split())
arr = list(range(1, N+1))
path = [0] * M
def abc(level):
    if level==M:
        for i in range(M):
            print(path[i], end=' ')
        print()
        return
    for i in range(N):
        path[level]=i+1
        abc(level+1)

abc(0)