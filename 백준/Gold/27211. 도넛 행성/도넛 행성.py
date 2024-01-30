from collections import deque

def bfs(y, x):
    q = deque()
    q.append((y, x))

    while q:
        y, x = q.popleft()
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = y+dy, x+dx
            ny, nx = (ny+n)%n, (nx+m)%m
            if visited[ny][nx]==0 and arr[ny][nx]==0:
                visited[ny][nx]=1
                q.append((ny, nx))


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

cnt = 0
for i in range(n):
    for j in range(m):
        if arr[i][j]==0 and visited[i][j]==0:
            bfs(i, j)
            cnt += 1

print(cnt)