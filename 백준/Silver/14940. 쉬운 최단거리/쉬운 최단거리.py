from collections import deque

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

sy, sx = 0, 0
for i in range(n):
    for j in range(m):
        if arr[i][j]==2:
            sy, sx = i, j
            break

visited = [[0]*m for _ in range(n)]

q = deque()
q.append((sy, sx))

while q:
    y, x = q.popleft()
    for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
        ny, nx = y+dy, x+dx
        if 0<=ny<n and 0<=nx<m and visited[ny][nx]==0 and arr[ny][nx]==1 and (ny!=sy or nx!=sx):
            visited[ny][nx] = visited[y][x]+1
            q.append((ny, nx))

# 원래 arr이 1이면서, visited가 0인 경우에는 -1로 바꾸기
for i in range(n):
    for j in range(m):
        if arr[i][j]==1 and not visited[i][j]:
            visited[i][j] = -1

for i in visited:
    print(*i)