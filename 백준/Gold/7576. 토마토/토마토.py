from collections import deque

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(m)]

q = deque()
for i in range(m):
    for j in range(n):
        if arr[i][j] == 1:
            q.append((i, j, 0))

def bfs():
    level = 0  # level 변수를 밖에서 초기화
    while q:
        y, x, level = q.popleft()  # level 변수를 여기서 업데이트
        for dy, dx in ((0, 1), (0, -1), (-1, 0), (1, 0)):
            ny, nx = y + dy, x + dx
            if 0 <= ny < m and 0 <= nx < n and arr[ny][nx] == 0:
                arr[ny][nx] = 1
                q.append((ny, nx, level + 1))
    return level  # level을 반환

result = bfs()

# 추가된 부분: 모든 토마토가 익었는지 확인
for row in arr:
    if 0 in row:
        print(-1)
        exit()

print(result)