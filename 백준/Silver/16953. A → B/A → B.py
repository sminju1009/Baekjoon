from collections import deque

a, b = map(int, input().split())
maxi = b+1

def bfs(start, end):
    q = deque()
    q.append((start, 0))

    while q:
        y, level = q.popleft()
        if y==end:
            return level

        for ny in [y*2, y*10+1]:
            if 0<=ny<maxi:
                q.append((ny, level+1))

    return -1

res = bfs(a, b)
if res==-1:
    print(res)
else:
    print(res+1)