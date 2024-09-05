from collections import deque

def bfs():
    q0 = deque([(0, 0)])
    q1 = deque([])
    while q0:
        y, x = q0.popleft()
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy+y, dx+x
            if 0<=ny<n and 0<=nx<m and not visited[ny][nx]:
                visited[ny][nx] = 1
                if arr[ny][nx]==0:
                    q0.append((ny, nx))
                else:
                    q1.append((ny, nx))

    for y, x in q1: # 치즈 녹이기
        arr[y][x] = 0

    return len(q1)

n, m = map(int, input().split())
cnt = 0
time = 1
arr = [list(map(int, input().split())) for _ in range(n)]
for i in range(n):
    cnt += sum(arr[i])

while True:
    visited = [[0]*m for _ in range(n)]
    melt = bfs()
    cnt -= melt
    if cnt==0:
        print(time)
        print(melt)
        break
    time+=1