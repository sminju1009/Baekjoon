import sys
sys.setrecursionlimit(10**6)

def dfs(y, x, color):
    global cnt
    visited[y][x] = 1
    cnt += 1
    for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
        ny, nx = dy + y, dx + x
        if 0 <= ny < n and 0 <= nx < m and arr[ny][nx] == color and visited[ny][nx] == 0:
            dfs(ny, nx, color)

m, n = map(int, input().split())
arr = [list(input().strip()) for _ in range(n)]
visited = [[0] * m for _ in range(n)]

w, b = 0, 0
# W = 우리팀 병사 / B = 적국 병사
for i in range(n):
    for j in range(m):
        if arr[i][j] == 'W' and visited[i][j] == 0:
            cnt = 0
            dfs(i, j, 'W')
            w += cnt**2
        elif arr[i][j] == 'B' and visited[i][j] == 0:
            cnt = 0
            dfs(i, j, 'B')
            b += cnt**2

print(w, b)