from collections import deque

n, m = map(int, input().split())
arr = [list(input()) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

def bfs(y, x):
    q = deque()
    q.append((y, x))
    visited[y][x] = 1
    level = 0

    while q:
        y, x= q.popleft()
        for dy, dx in ((0, -1), (0, 1), (-1, 0), (1, 0)):
            ny, nx = dy+y, dx+x

            if 0<=ny<n and 0<=nx<m and visited[ny][nx]==0:
                if arr[ny][nx]=='O':        # 빈 공간을 만나면 - 이동하기
                    visited[ny][nx]=1
                    q.append((ny, nx))
                elif arr[ny][nx]=='P':      # 사람을 만나면
                    visited[ny][nx] = 1
                    q.append((ny, nx))
                    level += 1
    return level

result = 0
for i in range(n):
    for j in range(m):
        if arr[i][j]=='I':
            result = bfs(i, j)

if result==0:
    print('TT')
else:
    print(result)