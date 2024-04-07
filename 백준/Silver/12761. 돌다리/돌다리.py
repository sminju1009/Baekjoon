from collections import deque

a, b, n, m = map(int, input().split())

visited = [0]*100002
q = deque()
q.append((n, 0))
visited[n] = 1

while q:
    y, level = q.popleft()

    if y==m:
        print(level)
    for dy in (y-1, y+1, y-a, y-b, y+a, y+b, y*a, y*b):
        if 0<=dy<100002 and visited[dy]==0:
            visited[dy] = 1
            q.append((dy, level+1))