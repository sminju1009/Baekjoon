from collections import deque

n = int(input())
arr = list(map(int, input().split()))
visited = [[0]*n for _ in range(n)]
def bfs(y1, x1, y2, x2):
    q = deque()
    q.append((y1, x1, 0))
    visited[y1][x1] = 1

    while q:
        y, x, level = q.popleft()
        for dy, dx in ((-2, -1), (-2, 1), (0, -2), (0, 2), (2, -1), (2, 1)):
            ny, nx = y+dy, x+dx
            if 0<=ny<n and 0<=nx<n and visited[ny][nx]==0:
                visited[ny][nx] = 1
                q.append((ny, nx, level+1))
                if ny==y2 and nx==x2:
                    return level+1

ans = bfs(arr[0], arr[1], arr[2], arr[3])
if ans==None:
    print(-1)
else:
    print(ans)