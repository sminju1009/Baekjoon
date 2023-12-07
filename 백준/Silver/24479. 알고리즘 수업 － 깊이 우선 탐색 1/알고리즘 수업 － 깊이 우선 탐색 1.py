import sys
sys.setrecursionlimit(150000)
input = sys.stdin.readline

v = 1
def dfs(t):
    global v
    visited[t] = v
    graph[t].sort()
    for g in graph[t]:
        if visited[g]==0:
            v += 1
            dfs(g)

# n은 정점 집합 m은 간선 집합 r은 시작 정점
n, m, r = map(int, input().split())
graph = [[]*n for _ in range(n+1)]
visited = [0]*(n+1)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 방문
dfs(r)
for i in range(1, n + 1):
    print(visited[i])