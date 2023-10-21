# 내 풀이

from collections import deque

n = int(input())
# 보통 사람이 보는 구역
arr = [list(input()) for _ in range(n)]
# 적록색약이 보는 사람들이 보는 구역

visited = [[0]*n for _ in range(n)]

def bfs(y, x):
    q = deque()
    q.append((y, x))
    visited[y][x] = 1

    while q:
        y, x = q.popleft()
        for dy, dx in ((0, -1), (0, 1), (-1, 0), (1, 0)):
            ny, nx = dy+y, dx+x
            if 0<=ny<n and 0<=nx<n and arr[ny][nx]==arr[y][x] and visited[ny][nx]==0:
                q.append((ny, nx))
                visited[ny][nx]=1


# 적록색맹 아닌 사람의 결과값 - cnt1
cnt1 = 0
for i in range(n):
    for j in range(n):
        if visited[i][j]==0:
            bfs(i, j)
            cnt1 += 1

for i in range(n):
    for j in range(n):
        if arr[i][j]=='G':
            arr[i][j] = 'R'

visited = [[0]*n for _ in range(n)]
# 적록색맹인 사람의 결과값 - cnt2
cnt2 = 0
for i in range(n):
    for j in range(n):
        if visited[i][j] == 0:
             bfs(i, j)
             cnt2 +=1

print(cnt1, cnt2)