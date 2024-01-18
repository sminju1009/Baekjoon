from collections import deque

def bfs(start):
    cnt = 1
    visited = [0]*(n+1)
    q = deque()
    q.append(start)
    visited[start] = 1

    while q:
        cur = q.popleft()
        for nx in arr[cur]:
            if visited[nx]==0:
                visited[nx] = 1
                q.append(nx)
                cnt += 1
    return cnt

n, m = map(int, input().split())
arr = [[]*(n+1) for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    arr[b].append(a)

res = [0]*(n+1)
for i in range(1, n+1):
    res[i] = bfs(i)

max_cnt = max(res)
for i in range(1, n+1):
    if res[i] == max_cnt:
        print(i, end=" ")