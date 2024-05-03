import sys
sys.setrecursionlimit(10**6)

def dfs(x, depth):
    global arrive
    visited[x] = 1
    if depth==5:
        arrive = 1
        return
    for i in arr[x]:
        if visited[i]==0:
            dfs(i, depth+1)
    visited[x] = 0

n, m = map(int, input().split())
visited = [0] * n
arr = [[] for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    if b not in arr[a]:
        arr[a].append(b)
    if a not in arr[b]:
        arr[b].append(a)

arrive = 0
for i in range(n):
    dfs(i, 1)
    if arrive==1:
        break

print(arrive)