def dfs(level):
    if level==m:
        print(*lst)
        return
    for i in range(1, n+1):
        if path[i-1]==0:
            path[i-1] = 1
            lst.append(i)
            dfs(level+1)
            path[i-1] = 0
            lst.remove(lst[-1])


n, m = map(int, input().split())
arr = [i for i in range(1, n+1)]
path = [0] * n
lst = []

dfs(0)