# 백준 11724 연결 요소의 개수

from collections import deque

def bfs(arr, start, visited):
    q = deque([start])
    visited[start] = 1
    while q:
        v = q.popleft()
        for i in arr[v]:
            if visited[i]==0:
                q.append(i)
                visited[i] = 1

n, m = map(int, input().split())
arr = [[] for _ in range(n)]

for _ in range(m):
    u, v = map(int, input().split())
    u, v = u-1, v-1
    arr[u].append(v)
    arr[v].append(u)

# visited 배열
visited = [0]*n


cnt = 0
for i in range(n):
    if visited[i]==0:
        bfs(arr, i, visited)
        cnt += 1

print(cnt)