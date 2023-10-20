from collections import deque

n, m = map(int, input().split())
arr = [list(map(int, input())) for _ in range(n)]

visited = [[[0, 0] for _ in range(m)] for _ in range(n)]

def bfs(y, x):
    q = deque()
    q.append((y, x, 0))
    visited[y][x][0] = 1

    while q:
        y, x, break_cnt = q.popleft()

        if y == n - 1 and x == m - 1:
            return visited[y][x][break_cnt]

        for dy, dx in ((0, -1), (0, 1), (-1, 0), (1, 0)):
            ny, nx = dy + y, dx + x
            if 0 <= ny < n and 0 <= nx < m:
                if arr[ny][nx] == 1 and break_cnt == 0:
                    visited[ny][nx][1] = visited[y][x][0] + 1
                    q.append((ny, nx, 1))

                if arr[ny][nx] == 0 and visited[ny][nx][break_cnt] == 0:
                    visited[ny][nx][break_cnt] = visited[y][x][break_cnt] + 1
                    q.append((ny, nx, break_cnt))

    return -1

print(bfs(0, 0))
