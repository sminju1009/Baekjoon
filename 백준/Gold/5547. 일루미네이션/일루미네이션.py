from collections import deque

directions = [
    [(-1, -1), (-1, 0), (0, 1), (1, 0), (1, -1), (0, -1)],
    [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (0, -1)]
]

w, h = map(int, input().split())
area = [[0 for _ in range(w + 2)] for _ in range(h + 2)]
for i in range(1, h + 1):
    area[i][1: w + 1] = map(int, input().split())

visited = [[0] * (w+2) for _ in range(h+2)]

q = deque([(0, 0)])
visited[0][0] = 1
answer = 0
while q:
    y, x = q.popleft()
    for dy, dx in directions[y%2]:
        ny, nx = y+dy, x+dx
        if 0<=ny<h+2 and 0<=nx<w+2:
            if area[ny][nx]==1:
                answer += 1
                continue
            if not visited[ny][nx]:
                q.append((ny, nx))
                visited[ny][nx] = 1

print(answer)