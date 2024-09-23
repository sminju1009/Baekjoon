def dfs(level, money):
    global cost, n
    if level==3:
        cost = min(cost, money)
        return
    for i in range(1, n-1):
        for j in range(1, n-1):
            flag = True
            for k in range(5):
                ny = i+dy[k]
                nx = j+dx[k]
                if visited[ny][nx]:
                    flag = False
            if flag:
                for k in range(5):
                    ny = i+dy[k]
                    nx = j+dx[k]
                    visited[ny][nx] = 1
                dfs(level+1, money+arr[i][j]+arr[i-1][j]+arr[i+1][j]+arr[i][j-1]+arr[i][j+1])
                for k in range(5):
                    ny = i + dy[k]
                    nx = j + dx[k]
                    visited[ny][nx] = 0


n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

dy = [0, -1, 1, 0, 0]
dx = [0, 0, 0, -1, 1]

visited = [[0]*n for _ in range(n)]

cost = 10000
dfs(0, 0)
print(cost)