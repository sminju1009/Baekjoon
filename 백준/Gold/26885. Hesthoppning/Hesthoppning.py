from collections import deque

def bfs(y, x):
    q = deque()
    q.append((y, x))
    visited[y][x] = 1

    while q:
        y, x = q.popleft()
        for dy, dx in (1, -2), (1, 2), (2, 1), (2, -1), (-1, -2), (-1, 2), (-2, 1), (-2, -1):
            ny, nx = y+dy, x+dx
            if 0<=ny<n and 0<=nx<n and visited[ny][nx]==0:
                if arr[ny][nx]=='.':
                    visited[ny][nx] = 1
                    q.append((ny, nx))
                elif arr[ny][nx]=='H':
                    return 'JA'

    return 'NEJ'

n, m = map(int, input().split())
arr = [list(input()) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

# 한 말을 파스칼로 바꾸기
for i in range(n):
    for j in range(m):
        if arr[i][j]=='H':
            y, x = i, j
            break

print(bfs(y, x))