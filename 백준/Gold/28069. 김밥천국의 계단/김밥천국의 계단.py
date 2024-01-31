from collections import deque

n, k = map(int, input().split())
visited = [-1] * 1000001

q = deque()
q.append(0)
visited[0] = 0

while q:
    y = q.popleft()
    if y==n:
        if visited[y]<=k:
            print('minigimbob')
            break
        else:
            print('water')
            break
    if 0<=y+1<1000001 and visited[y+1]==-1:
        visited[y+1] = visited[y] + 1
        q.append(y+1)
    if 0<=y+y//2<1000001 and visited[y+y//2]==-1:
        visited[y+y//2] = visited[y] + 1
        q.append(y+y//2)