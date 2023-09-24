from collections import deque

n, m = map(int, input().split())    # 세로, 가로
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

# 섬 크기 구하는 함수
def bfs(i, j):
    size = 0
    dy = [0, 0, -1, 1]
    dx = [-1, 1, 0, 0]
    q = deque()
    q.append((i, j))

    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = dy[i]+y
            nx = dx[i]+x
            if 0<=ny<n and 0<=nx<m:
                if visited[ny][nx]==0 and arr[ny][nx]==1:
                    visited[ny][nx]=1
                    q.append((ny, nx))
                    size += 1
    return size

result = []

for i in range(n):
    for j in range(m):
        if arr[i][j]==1 and visited[i][j]==0:
            visited[i][j] = 1
            pic = bfs(i, j)
            result.append(pic)

if len(result)==0:
    print(len(result))
    print(0)
else:
    print(len(result))
    print(max(result)+1)