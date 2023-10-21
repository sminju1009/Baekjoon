# gpt

from collections import deque

n = int(input())
arr = [list(input()) for _ in range(n)]

def bfs(y, x, color, visited):
    q = deque()
    q.append((y, x))
    visited[y][x] = 1

    while q:
        y, x = q.popleft()
        for dy, dx in ((0, -1), (0, 1), (-1, 0), (1, 0)):
            ny, nx = dy + y, dx + x
            if 0 <= ny < n and 0 <= nx < n and arr[ny][nx] == color and not visited[ny][nx]:
                q.append((ny, nx))
                visited[ny][nx] = 1

# 적록색약이 아닌 경우
visited = [[0] * n for _ in range(n)]
cnt1 = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j, arr[i][j], visited)
            cnt1 += 1

# 적록색약인 경우 (R과 G를 같은 색으로 처리)
visited = [[0] * n for _ in range(n)]
cnt2 = 0
for i in range(n):
    for j in range(n):
        if arr[i][j]=='G':
            arr[i][j] = 'R'
            
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j, arr[i][j], visited)
            cnt2 += 1

print(cnt1, cnt2)