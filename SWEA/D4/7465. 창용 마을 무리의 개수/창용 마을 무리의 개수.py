from collections import deque

def bfs(x):
    q = deque()
    q.append(x)
    visited[x] = 1

    while q:
        x = q.popleft()
        for i in arr[x]:
            if visited[i] ==0:
                visited[i] = 1
                q.append(i)

T = int(input())

for tc in range(1, T+1):
    n, m = map(int, input().split())
    visited = [0] * (n+1)
    arr = [[] for _ in range(n+1)]
    for _ in range(m):
        a, b = map(int, input().split())
        arr[a].append(b)
        arr[b].append(a)

    cnt = 0
    for i in range(1, n+1):
        if visited[i] == 0:
            bfs(i)
            cnt += 1

    print(f'#{tc} {cnt}')