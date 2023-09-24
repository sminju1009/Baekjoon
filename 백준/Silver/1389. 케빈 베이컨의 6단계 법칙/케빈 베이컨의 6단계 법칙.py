from collections import deque

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)



def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = 1

    while q:
        target = q.popleft()
        for i in graph[target]:
            if visited[i]==0:
                # 친구 관계를 확인하고 탐색하지 않은 친구라면 탐색
                visited[i] = visited[target]+1
                q.append(i)

res = []

# 탐색하면서 탐색하기까지 걸린 횟수를 체크
for i in range(1, n+1):
    visited = [0] * (n + 1)
    bfs(i)
    res.append(sum(visited))

# 인쇄하기
print(res.index(min(res))+1)