def dfs(level, array):
    if level==len(a):
        result.append(array[:])
        return
    prev = ""
    for i in range(len(a)):
        if not visited[i] and prev!=a[i]:
            prev = a[i]
            visited[i] = 1
            dfs(level+1, array+[a[i]])
            visited[i] = 0

n = int(input())
for _ in range(n):
    a = sorted(list(input()))
    visited = [0] * len(a)
    result = []
    dfs(0, [])
    for i in result:
        print("".join(i))