from collections import deque

def solution(n, edge):
    answer = 0
    arrays = [[] for _ in range(n+1)]
    visited = [0] * (n+1)
    for i, j in edge:
        arrays[i].append(j)
        arrays[j].append(i)
    
    q = deque()
    q.append(1)
    visited[1] = 1
    
    while q:
        x = q.popleft()
        for y in arrays[x]:
            if not visited[y]:
                visited[y] = visited[x] + 1
                q.append(y)
    
    print(visited)
    
    for i in range(1, n+1):
        if visited[i]==max(visited):
            answer+=1
            
    return answer