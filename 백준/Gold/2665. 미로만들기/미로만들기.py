from collections import deque

n = int(input())
arr = [list(map(int, input())) for _ in range(n)]
visited = [[0]*n for _ in range(n)]

q = deque()
q.append((0, 0))
visited[0][0] = 1

while q:
    y, x = q.popleft()
    if y==n-1 and x==n-1:
        print(visited[y][x]-1)
        break
    for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
        ny, nx = dy+y, dx+x
        if 0<=ny<n and 0<=nx<n and visited[ny][nx]==0:
            if arr[ny][nx]==1:
                visited[ny][nx] = visited[y][x]
                q.appendleft((ny, nx))
            elif arr[ny][nx]==0:
                visited[ny][nx] = visited[y][x]+1
                q.append((ny, nx))