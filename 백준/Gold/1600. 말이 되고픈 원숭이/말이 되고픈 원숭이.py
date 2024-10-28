from collections import deque

dist = [(0, 1), (-1, 0), (0, -1), (1, 0)]
horse = [(-2, -1), (-2, 1), (-1, -2), (-1, 2), (2, -1), (2, 1), (1, -2), (1, 2)]

k = int(input())
w, h = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(h)]
visited = [[[0]*(k+1) for _ in range(w)] for _ in range(h)]

q = deque()
q.append((0, 0, 0))

flag = False
while q:
    y, x, level = q.popleft()
    if x==w-1 and y==h-1:
        flag = True
        print(visited[y][x][level])
        break
    for dy, dx in dist:
        ny, nx = y+dy, x+dx
        if 0<=ny<h and 0<=nx<w and not visited[ny][nx][level] and not arr[ny][nx]:
            visited[ny][nx][level] = visited[y][x][level] + 1
            q.append((ny, nx, level))

    if level<k:
        for dy, dx in horse:
            ny, nx = dy+y, dx+x
            if 0<=ny<h and 0<=nx<w:
                if not arr[ny][nx]:
                    if not visited[ny][nx][level+1]:
                        visited[ny][nx][level+1] = visited[y][x][level] + 1
                        q.append((ny, nx, level+1))

if not flag:
    print(-1)