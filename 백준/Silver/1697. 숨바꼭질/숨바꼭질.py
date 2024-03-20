from collections import deque

def bfs():
    q = deque()
    q.append(n)
    visited[n] = 1

    while q:
        y = q.popleft()
        if y==k:
            print(visited[k]-1)
            return
        for dy in (y*2, y+1, y-1):
            if 0<=dy<=100000 and visited[dy]==0:
                visited[dy] = visited[y] + 1
                q.append(dy)


n, k = map(int, input().split())
visited = [0]*100001
bfs()