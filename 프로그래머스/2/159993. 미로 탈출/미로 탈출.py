from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    sy, sx = 0, 0
    ey, ex = 0, 0
    ly, lx = 0, 0
    
    for i in range(n):
        for j in range(m):
            if maps[i][j]=="S":
                sy, sx = i, j
            if maps[i][j]=="E":
                ey, ex = i, j
            if maps[i][j]=="L":
                ly, lx = i, j
                
    
    
    # 1. 레버를 찾는 함수
    def bfs_l(s_y, s_x, l_y, l_x):
        visited = [[0]*m for _ in range(n)]
        q = deque()
        q.append((s_y, s_x, 0))
        visited[s_y][s_x] = 1

        while q:
            y, x, level = q.popleft()
            if y==l_y and x==l_x:
                return level
            for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
                ny, nx = dy+y, dx+x
                if 0<=ny<n and 0<=nx<m and maps[ny][nx]!="X":
                    if visited[ny][nx]==0:
                        visited[ny][nx] = 1
                        q.append((ny, nx, level+1))
                    
        return -1
    
    # 2. 출구를 찾는 함수
    def bfs_exit(l_y, l_x, e_y, e_x):
        visited = [[0]*m for _ in range(n)]
        q = deque()
        q.append((l_y, l_x, 0))
        visited[l_y][l_x] = 1
        
        while q:
            y, x, level = q.popleft()
            if y==e_y and x==e_x:
                return level
            for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
                ny, nx = dy+y, dx+x
                if 0<=ny<n and 0<=nx<m and maps[ny][nx]!="X":
                    if visited[ny][nx]==0:
                        q.append((ny, nx, level+1))
                        visited[ny][nx] = 1
                    
        return -1
    
    answer1 = bfs_l(sy, sx, ly, lx)
    answer2 = bfs_exit(ly, lx, ey, ex)
    
    if answer1==-1 or answer2==-1:
        return -1
    else:
        return answer1+answer2