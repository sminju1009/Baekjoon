def solution(n):
    answer = []
    arr = [[0] * i for i in range(1, n+1)]
    end_num = n*(n+1)//2
    dirs = [(1, 0), (0, 1), (-1, -1)]
    turn = 0
    y, x = 0, 0
    i = 1
    
    while i<=end_num:
        arr[y][x] = i
        i += 1
        dy, dx = dirs[turn]
        ny = y+dy
        nx = x+dx
        if 0<=ny<n and 0<=nx<n and arr[ny][nx] == 0:
            y, x = ny, nx
        else:
            turn = (turn+1)%3
            dy, dx = dirs[turn]
            y += dy
            x += dx
    
    for row in arr:
        for item in row:
            answer.append(item)
    return answer