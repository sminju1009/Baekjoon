from collections import deque

def bfs(y, x):
    q = deque()
    q.append((y, x))
    visited[y][x] = 1

    while q:
        y, x = q.popleft()
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy + y, dx + x
            if 0 <= ny < n and 0 <= nx < m:
                if visited[ny][nx] == 0 and arr[ny][nx] == 0:
                    visited[ny][nx] = 1
                    q.append((ny, nx))
                elif arr[ny][nx] == 1:
                    visited[ny][nx] += 1

def cnt_find():
    answer = 0
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 1:
                answer += 1
    return answer

n, m = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

time = 0

while True:
    visited = [[0] * m for _ in range(n)]
    bfs(0, 0)

    melted = False  # 치즈가 녹았는지 확인
    for i in range(n):
        for j in range(m):
            if visited[i][j] >= 2:
                arr[i][j] = 0
                melted = True  # 치즈가 녹았음을 기록

    time += 1

    # 남은 치즈가 있는지 확인
    if cnt_find() == 0:
        break

print(time)