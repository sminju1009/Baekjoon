from collections import deque

def solution(n, edge):
    arrays = [[] for _ in range(n+1)]
    for i, j in edge:
        arrays[i].append(j)
        arrays[j].append(i)
    
    visited = [0] * (n+1)
        
    q = deque()
    q.append(1)
    visited[1] = 1
    
    while q:
        x = q.popleft()
        for i in arrays[x]:
            if not visited[i]:
                visited[i] = visited[x] + 1
                q.append(i)
    
    answer = max(visited)
    result = visited.count(answer)
    return result