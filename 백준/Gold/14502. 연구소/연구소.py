# https://jie0025.tistory.com/209

from collections import deque
import copy

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

def dfs(level):
    if level==3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if arr[i][j]==0:
                arr[i][j] = 1
                dfs(level+1)
                arr[i][j] = 0

def bfs():
    q = deque()
    arr2 = copy.deepcopy(arr)
    for i in range(n):
        for j in range(m):
            if arr2[i][j]==2:
                q.append((i, j))

    while q:
        y, x = q.popleft()

        for dy, dx in ((0, -1), (0, 1), (1, 0), (-1, 0)):
            ny, nx = y+dy, x+dx
            if 0<=ny<n and 0<=nx<m:
                if arr2[ny][nx]==0:
                    arr2[ny][nx]=2
                    q.append((ny, nx))

    global result
    count = 0
    for i in range(n):
        for j in range(m):
            if arr2[i][j]==0:
                count += 1

    result = max(result, count)

result = 0
dfs(0)

print(result)