from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    n = len(rectangle)
    arr = [[-1]*102 for _ in range(102)]
    visited = [[0]*102 for _ in range(102)]
    
    # 테두리 구하기
    for i in range(n):
        sx, sy, ex, ey = map(lambda x:x*2, rectangle[i])
        for j in range(sy, ey+1):
            for k in range(sx, ex+1):
                if sy<j<ey and sx<k<ex:
                    arr[j][k] = 0
                elif arr[j][k] != 0:
                    arr[j][k] = 1
    
    def bfs(y, x):
        q = deque()
        q.append((y, x))
        
        while q:
            y, x = q.popleft()
            if y == itemY*2 and x == itemX*2:
                return visited[y][x] // 2
            for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
                ny, nx = dy + y, dx + x
                if 0 <= ny < 102 and 0 <= nx < 102 and visited[ny][nx] == 0 and arr[ny][nx] == 1:
                    q.append((ny, nx))
                    visited[ny][nx] = visited[y][x] + 1
    
    return bfs(characterY*2, characterX*2)