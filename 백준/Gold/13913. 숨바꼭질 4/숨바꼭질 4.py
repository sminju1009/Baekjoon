from collections import deque

def path(x):
    arr = []
    temp = x
    for _ in range(dist[x]):
        arr.append(temp)
        temp = road[temp]
    print(' '.join(map(str, arr[::-1])))

def bfs():
    q = deque()
    q.append(n)
    dist[n] = 1

    while q:
        y = q.popleft()
        if y == m:
            print(dist[m] - 1)
            path(m)
            return
        for dy in (2*y, y+1, y-1):
            if 0<=dy<100001 and dist[dy]==0:
                q.append(dy)
                dist[dy] = dist[y] + 1
                road[dy] = y



n, m = map(int, input().split())
dist = [0] * 100001
road = [0] * 100001
bfs()