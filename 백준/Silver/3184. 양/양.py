from collections import deque

def bfs(y, x):
    o, v = 0, 0
    q = deque()
    q.append((y, x))
    if arr[y][x] == 'o':
        o += 1
    elif arr[y][x] == 'v':
        v += 1
    visited[y][x] = 1

    while q:
        y, x = q.popleft()
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy + y, dx + x
            if 0 <= ny < r and 0 <= nx < c and visited[ny][nx] == 0 and arr[ny][nx] != '#':
                q.append((ny, nx))
                visited[ny][nx] = 1
                if arr[ny][nx] == 'o':
                    o += 1
                elif arr[ny][nx] == 'v':
                    v += 1

    return o, v

r, c = map(int, input().split())
arr = [list(input()) for _ in range(r)]
visited = [[0] * c for _ in range(r)]
sheep, wolf = 0, 0

for i in range(r):
    for j in range(c):
        if arr[i][j] != '#' and visited[i][j] == 0:
            o, v = bfs(i, j)
            if o > v:
                sheep += o
            else:
                wolf += v

print(sheep, wolf)