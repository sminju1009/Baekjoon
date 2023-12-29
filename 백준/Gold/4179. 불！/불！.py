from collections import deque

def jihoon(y, x):
    q.append((y, x))
    visited[y][x] = 1

    while q:
        qlen = len(q)
        while qlen:
            y, x = q.popleft()
            for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
                ny, nx = dy + y, dx + x
                if 0 <= ny < r and 0 <= nx < c:
                    if arr[ny][nx]=='.' and visited[ny][nx]==0:
                        visited[ny][nx] = visited[y][x]+1
                        q.append((ny, nx))
                elif nx<0 or ny<0 or ny>=r or nx>=c:
                    print(visited[y][x])
                    return
            qlen -= 1
        fire_v()

    print('IMPOSSIBLE')
    return


def fire_v():
    qlen = len(fire)
    while qlen:
        y, x = fire.popleft()
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy+y, dx+x
            if 0<=ny<r and 0<=nx<c:
                if arr[ny][nx]=='.':
                    arr[ny][nx] = 'F'
                    fire.append((ny, nx))
        qlen -=1

r, c = map(int, input().split())
arr = [list(input()) for _ in range(r)]

# 지훈이를 넣을 deque
q = deque()

# 불을 넣을 deque
fire = deque()

# 지훈이가 다녀온 흔적
visited = [[0]*c for _ in range(r)]

for i in range(r):
    for j in range(c):
        if arr[i][j]=='J':
            sy, sx = i, j
            arr[i][j] = '.'
        if arr[i][j]=='F':
            fire.append((i, j))

fire_v()
jihoon(sy, sx)