from collections import deque

def bfs(y, x, level):
    q = deque()
    q.append((y, x, level))
    visited[y][x] = 1

    while q:
        y, x, level = q.popleft()
        if x>n-1:
            return 1
        for dy, dx in ((0, -1), (0, 1), (1, k), (-1, k)):
            ny, nx = dy+y, dx+x
            if ny==0 or ny==1:
                if 0<=nx<n and visited[ny][nx]==0 and arr[ny][nx]==1 and nx>level:
                    q.append((ny, nx, level+1))
                    visited[ny][nx] = 1
                elif nx>=n and nx>level:
                    q.append((ny, nx, level+1))
    return 0

n, k = map(int, input().split())
visited = [[0]*n for _ in range(2)]
arr = []
for _ in range(2):
    lst = list(map(int, input()))
    arr.append(lst)

print(bfs(0, 0, 0))