def dfs(a, alst):
    if a==m:
        ans.append(alst)
        return

    prev = 0
    for j in range(n):
        if v[j]==0 and prev!=lst[j]:
            prev=lst[j]
            v[j] = 1
            dfs(a+1, alst+[lst[j]])
            v[j] = 0

n, m = map(int, input().split())
lst = sorted(list(map(int, input().split())))

ans = []
v = [0] * n
dfs(0, [])

for lst in ans:
    print(*lst)