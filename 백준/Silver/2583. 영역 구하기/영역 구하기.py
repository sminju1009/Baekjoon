from collections import deque

m, n, k = map(int, input().split())     # 세로, 가로, 영역 개수
arr = [[0]*n for _ in range(m)]
for _ in range(k):
    sx, sy, ex, ey = map(int, input().split())
    for i in range(sy, ey):
        for j in range(sx, ex):
            arr[i][j] = 1

def bfs(y, x):
    q = deque()
    q.append((y, x))
    arr[y][x] = 1
    
    size = 1
    dy = [0, 0, -1, 1]
    dx = [-1, 1, 0, 0]
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y+dy[i]
            nx = x+dx[i]
            if 0<=ny<m and 0<=nx<n and arr[ny][nx]==0:
                arr[ny][nx] = 1
                q.append((ny, nx))
                size += 1
    result.append(size)

result = []
for i in range(m):
    for j in range(n):
        if arr[i][j]==0:
            bfs(i, j)

result.sort()
print(len(result))
for i in result:
    print(i, end=' ')