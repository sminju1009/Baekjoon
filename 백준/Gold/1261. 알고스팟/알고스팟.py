from collections import deque

n, m = map(int, input().split())
arr = [list(map(int, input())) for _ in range(m)]
visited = [[0]*n for _ in range(m)]

q = deque()
q.append((0, 0))
visited[0][0] = 1

while q:
    y, x = q.popleft()
    if y==m-1 and x==n-1:
        print(visited[y][x] - 1)
        break
    for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
        ny, nx = dy+y, dx+x
        if 0<=ny<m and 0<=nx<n and visited[ny][nx]==0:
            if arr[ny][nx]==0:
                visited[ny][nx] = visited[y][x]
                q.appendleft((ny, nx))
            elif arr[ny][nx]==1:
                visited[ny][nx] = visited[y][x]+1
                q.append((ny, nx))