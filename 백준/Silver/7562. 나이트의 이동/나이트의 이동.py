from collections import deque

def bfs(y1, x1, y2, x2):
    if y1==y2 and x1==x2:
        return 0
    q = deque()
    q.append((y1, x1, 1))
    arr[y1][x1] = 1

    while q:
        y, x, level = q.popleft()
        for dy, dx in ((-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2), (-2, -1), (-1, -2)):
            ny, nx = y+dy, x+dx
            if 0<=ny<l and 0<=nx<l and arr[ny][nx]==0:
                q.append((ny, nx, level+1))
                arr[ny][nx] = 1
                if ny==y2 and nx==x2:
                    return level

n = int(input())

for tc in range(n):
    l = int(input())
    sy, sx = map(int, input().split())
    ey, ex = map(int, input().split())

    arr = [[0]*l for _ in range(l)]
    result = bfs(sy, sx, ey, ex)
    print(result)