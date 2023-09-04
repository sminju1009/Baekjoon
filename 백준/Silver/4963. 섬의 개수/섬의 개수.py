# 백준 4963
from collections import deque

def bfs(y, x):
    arr[y][x] = 0
    q = deque()
    q.append([y, x])

    while q:
        y, x = q.popleft()

        dy = [-1, -1, -1, 0, 1, 1, 1, 0]
        dx = [-1, 0, 1, 1, 1, 0, -1, -1]
        for i in range(8):
            ny = y+dy[i]
            nx = x+dx[i]
            if 0<=ny<h and 0<=nx<w and arr[ny][nx]==1:
                arr[ny][nx]=0
                q.append([ny, nx])


while True:
    w, h=map(int, input().split())
    if w==0 and h==0:
        break
    arr = []
    count = 0
    for _ in range(h):
        arr.append(list(map(int, input().split())))
    for i in range(h):
        for j in range(w):
            if arr[i][j]==1:
                bfs(i, j)
                count += 1
    print(count)