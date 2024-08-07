from collections import deque

def bfs(start):
    q = deque()
    q.append(start)
    colors[start] = 1

    while q:
        y = q.popleft()
        for i in graph[y]:
            if colors[i] == 0:
                if colors[y] == 1:
                    colors[i] = 2
                elif colors[y] == 2:
                    colors[i] = 1
                q.append(i)
            else:
                if colors[y] == colors[i]:
                    return False
    return True

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
colors = [0] * (n+1)
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# 해당 그래프가 이분 그래프인지 판별하기
answer = True
for i in range(1, n+1):
    if colors[i]==0:
        if not bfs(i):
            answer = False
            break

if answer:
    cnt1 = colors.count(1)
    cnt2 = colors.count(2)
    print(cnt1*cnt2*2)
else:
    print(0)