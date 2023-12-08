import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

v = 1

def dfs(start):
    global v
    visited[start] = v

    v = v+1
    graph[start].sort(reverse=True)
    for i in graph[start]:
        if visited[i]==0:
            dfs(i)

# 정점 수, 간선 수, 시작 정점
n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
visited = [0] * (n+1)

dfs(r)

print(*visited[1:], sep="\n")