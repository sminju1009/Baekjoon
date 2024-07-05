from collections import deque

def bfs(y, x):
    q = deque()
    q.append((y, x))
    visited[y][x] = 1
    cnt = 1

    while q:
        y, x = q.popleft()
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy+y, dx+x
            if 0<=ny<n and 0<=nx<m and visited[ny][nx]==0 and arr[ny][nx]=='#':
                q.append((ny, nx))
                visited[ny][nx] = 1
                cnt += 1

    return cnt

n, m, k = map(int, input().split())
arr = [['.']*m for _ in range(n)]
for _ in range(k):
    r, c = map(int, input().split())
    arr[r-1][c-1] = '#'

visited = [[0]*m for _ in range(n)]
answer = []
for i in range(n):
    for j in range(m):
        if arr[i][j]=='#' and visited[i][j]==0:
            answer.append(bfs(i, j))

print(max(answer))