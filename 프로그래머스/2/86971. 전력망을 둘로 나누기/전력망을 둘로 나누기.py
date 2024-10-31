from collections import deque

def solution(n, wires):
    answer = 500
    arr = [[] for _ in range(n+1)]
    for i, j in wires:
        arr[i].append(j)
        arr[j].append(i)
    
    def bfs(start):
        visited = [0] * (n+1)
        q = deque()
        q.append(start)
        cnt = 1
        visited[start] = 1
        
        while q:
            y = q.popleft()
            for i in arr[y]:
                if not visited[i]:
                    visited[i] = 1
                    cnt += 1
                    q.append(i)
                
        return cnt
            
        
    for i, j in wires:
        arr[i].remove(j)
        arr[j].remove(i)
        
        answer = min(abs(bfs(i)-bfs(j)), answer)
        
        arr[i].append(j)
        arr[j].append(i)
    return answer