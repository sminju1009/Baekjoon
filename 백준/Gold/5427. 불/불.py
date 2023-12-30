from collections import deque

def sg(y, x):
    sg_q.append((y, x))
    visited[y][x] = 1

    while sg_q:
        q_len = len(sg_q)
        while q_len:
            y, x = sg_q.popleft()

            for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
                ny, nx = dy+y, dx+x
                if 0<=ny<h and 0<=nx<w:
                    if arr[ny][nx]=='.' and visited[ny][nx]==0:
                        visited[ny][nx] = visited[y][x] + 1
                        sg_q.append((ny, nx))
                else:
                    print(visited[y][x])
                    return
            q_len -= 1
        fire()

    print('IMPOSSIBLE')
    return

def fire():
    q_len = len(fire_q)

    while q_len:
        y, x = fire_q.popleft()
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy+y, dx+x
            if 0<=ny<h and 0<=nx<w:
                if arr[ny][nx]=='.':
                    arr[ny][nx] = '*'
                    fire_q.append((ny, nx))
        q_len -= 1


n = int(input())

for tc in range(n):
    w, h = map(int, input().split())
    arr = [list(input()) for _ in range(h)]
    visited = [[0]*w for _ in range(h)]

    # 상근이가 들어갈 큐
    sg_q = deque()

    # 불이 들어갈 큐
    fire_q = deque()

    for i in range(h):
        for j in range(w):
            if arr[i][j]=='@':
                sy, sx = i, j
                arr[i][j] = '.'
            if arr[i][j]=='*':
                fire_q.append((i, j))

    fire()
    sg(sy, sx)