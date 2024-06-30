from collections import deque

def bfs():
    q = deque()
    q.append(a-1)
    visited[a-1] = 1

    while q:
        y = q.popleft()
        for dy in range(n):
            if visited[dy]==0 and (dy-y)%arr[y]==0:
                q.append(dy)
                visited[dy] = visited[y] + 1
                if dy==b-1:
                    return visited[dy]-1
    return -1

n = int(input())
arr = list(map(int, input().split()))
a, b = map(int, input().split())

visited = [0] * (n+1)

print(bfs())