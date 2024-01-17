from collections import deque

def bfs(y, x):
    q = deque()
    q.append((y, x))
    visited[y][x] = 1
    arr[y][x] = 2

    while q:
        y, x = q.popleft()
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy+y, dx+x
            if 0<=ny<m and 0<=nx<n:
                if arr[ny][nx]==0 and visited[ny][nx]==0:
                    visited[ny][nx] = 1
                    q.append((ny, nx))
                    arr[ny][nx] = 2

m, n = map(int, input().split())
arr = [list(map(int, input())) for _ in range(m)]
visited = [[0]*n for _ in range(m)]

for i in range(n):
    if arr[0][i]==0 and visited[0][i]==0:
        bfs(0, i)

res = 0
for i in range(n):
    if arr[m-1][i]==2:
        res = 1

if res==1:
    print('YES')
else:
    print('NO')