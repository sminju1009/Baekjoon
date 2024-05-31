from collections import deque

def bfs(y, x, visited):
    q = deque()
    q.append((y, x))
    visited[y][x] = 1

    while q:
        y, x = q.popleft()
        # 네 방향 범위 내 미방문, arr[y][x]>0
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy+y, dx+x
            if visited[ny][nx]==0 and arr[ny][nx]>0:
                q.append((ny, nx))
                visited[ny][nx] = 1

def solve():
    for year in range (1, 900000):
        # 1. 네방향 0 개수 카운트
        a_sub = [[0]*m for _ in range(n)]
        for i in range(1, n-1):
            for j in range(1, m-1):
                if arr[i][j]==0:
                    continue
                for dy, dx in ((0, -1), (-1, 0), (1, 0), (0, 1)):
                    ny, nx = dy+i, dx+j
                    if arr[ny][nx]==0:
                        a_sub[i][j] += 1
        # 2. 높이 낮추기
        for i in range(1, n-1):
            for j in range(1, m-1):
                if a_sub[i][j]>0:
                    arr[i][j] = max(0, arr[i][j]-a_sub[i][j])
        # 3. 덩어리 개수 카운트
        visited = [[0]*m for _ in range(n)]
        cnt = 0
        for i in range(1, n-1):
            for j in range(1, m-1):
                if visited[i][j]==0 and arr[i][j]>0:
                    bfs(i, j, visited)
                    cnt += 1
                    if cnt>1:
                        return year
        if cnt==0:
            return 0
    return -1

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

ans = solve()
print(ans)