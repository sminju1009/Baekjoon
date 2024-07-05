# bfs

from collections import deque

def bfs(y, x, color):
    q = deque()
    q.append((y, x))
    visited[y][x] = 1
    cnt = 1

    while q:
        y, x = q.popleft()
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy+y, dx+x
            if 0<=ny<n and 0<=nx<m and visited[ny][nx]==0 and arr[ny][nx]==color:
                cnt += 1
                q.append((ny, nx))
                visited[ny][nx] = 1

    return cnt

m, n = map(int, input().split())
arr = [list(input()) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

w, b = 0, 0
for i in range(n):
    for j in range(m):
        if arr[i][j]=='W' and visited[i][j]==0:
            w += bfs(i, j, arr[i][j])**2
        elif arr[i][j]=='B' and visited[i][j]==0:
            b += bfs(i, j, arr[i][j])**2

print(w, b)