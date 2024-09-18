def dfs(level):
    if level==n:
        print(*result)
        return
    for i in range(n):
        if not visited[i]:
            visited[i] = 1
            result[level] = i+1
            dfs(level+1)
            result[level] = 0
            visited[i] = 0

n = int(input())
arr = [i+1 for i in range(n)]
result = [0] * n
visited = [0] * n

dfs(0)