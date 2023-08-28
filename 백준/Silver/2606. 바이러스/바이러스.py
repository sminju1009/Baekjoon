# 바이러스

N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]
# graph[1] = [2, 5]
# graph[2] = [1, 3, 5]
visited = [0 for _ in range(N+1)]
# visited[1] = 0
# visited[1] = 1

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def recur(node):
    visited[node] = 1
    for nxt in graph[node]:
        if visited[nxt] == 1:       # 방문한 곳은 가지 않겠다.
            continue
        recur(nxt)



recur(1)

print(sum(visited)-1)