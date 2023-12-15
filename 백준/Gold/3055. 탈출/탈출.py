# 3055 탈출

from collections import deque

r, c = map(int, input().split())
arr = [list(input()) for _ in range(r)]
dist = [[0] * c for _ in range(r)]
q = deque()

def bfs(ay, ax):
    while q:
        y, x = q.popleft()
        if arr[ay][ax]=='S':
            return dist[ay][ax]
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy+y, dx+x
            if 0<=ny<r and 0<=nx<c:
                # 고슴도치가 이동할 때
                if arr[y][x]=='S':
                    if arr[ny][nx]=='.' or arr[ny][nx]=='D':
                        dist[ny][nx] = dist[y][x]+1
                        arr[ny][nx] = 'S'
                        q.append((ny, nx))
                # 물을 만나면
                elif arr[y][x] == '*':
                    if arr[ny][nx]=='.' or arr[ny][nx]=='S':
                        arr[ny][nx] = '*'
                        q.append((ny, nx))
    return 'KAKTUS'

for i in range(r):
    for j in range(c):
        if arr[i][j]=='S':
            q.append((i, j))
        elif arr[i][j] == 'D':
            ey, ex = i, j
            
for i in range(r):
    for j in range(c):
        if arr[i][j]=='*':
            q.append((i, j))

print(bfs(ey, ex))