from collections import deque

f, s, g, u, d = map(int, input().split())
visited = [0]*(f+1)

def bfs(s, g):
    q = deque()
    q.append((s, 0))  # 0은 level

    while q:
        s, level = q.popleft()
        if s == g:
            return level

        up = s + u
        if 1 <= up <= f and visited[up] == 0:
            visited[up] = 1
            q.append((up, level+1))

        down = s - d
        if 1 <= down <= f and visited[down] == 0:
            visited[down] = 1
            q.append((down, level+1))

result = bfs(s, g)
if result is None:
    print("use the stairs")
else:
    print(result)
