from collections import deque

n, m, r = map(int, input().split())
arr = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

for i in range(1, n+1):
    arr[i].sort(reverse=True)

visited = [0] * (n+1)

q = deque()
q.append(r)
visited[r] = 1
cnt = 1

while q:
    y = q.popleft()
    for i in arr[y]:
        if visited[i]==0:
            q.append(i)
            visited[i] = cnt + 1
            cnt += 1

print(*visited[1:], sep="\n")