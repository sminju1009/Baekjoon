from collections import deque

def solution(maps):
    
    answer = []
    n = len(maps)
    m = len(maps[0])
    
    # arr 새로 만들기
    arr = [[0 if j == 'X' else int(j) for j in i] for i in maps]     
    q = deque()
    visited = [[0]*m for _ in range(n)]
    
    for i in range(n):
        for j in range(m):
            if arr[i][j]!=0 and visited[i][j]==0:
                q.append((i, j))
                cnt = arr[i][j]
                visited[i][j] = 1
                
                while q:
                    y, x = q.popleft()
                    for dy, dx in ((0, -1), (0, 1), (-1, 0), (1, 0)):
                        ny, nx = dy+y, dx+x
                        if 0<=ny<n and 0<=nx<m and visited[ny][nx]==0 and arr[ny][nx]!=0:
                            q.append((ny, nx))
                            visited[ny][nx]=1
                            cnt += arr[ny][nx]
                            
                answer.append(cnt)
                
    if len(answer)==0:
        return [-1]
    else:
        answer.sort()
        return answer
