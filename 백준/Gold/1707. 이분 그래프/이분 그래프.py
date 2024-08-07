from collections import deque

def bfs(start):
    q = deque()
    q.append(start)
    colors[start] = 1

    while q:
        y = q.popleft()
        for i in graph[y]:
            if colors[i]==0:
                if colors[y]==1:
                    colors[i] = 2
                elif colors[y]==2:
                    colors[i] = 1
                q.append(i)
            else:
                if colors[y]==colors[i]:
                    return False
    return True


n = int(input())
for _ in range(n):
    v, e = map(int, input().split())
    graph = [[] for _ in range(v+1)]
    colors = [0] * (v+1)
    for _ in range(e):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    answer = True
    for i in range(1, v+1):
        if colors[i]==0:
            if bfs(i)==False:
                answer = False
                break

    if answer==True:
        print("YES")
    else:
        print("NO")