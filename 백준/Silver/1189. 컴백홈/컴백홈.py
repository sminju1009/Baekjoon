def dfs(y, x, dist):
    global cnt
    if y==0 and x==c-1 and dist==k:
        cnt += 1
        return
    visited[y][x] = 1
    for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
        ny, nx = dy+y, dx+x
        if 0<=ny<r and 0<=nx<c and not visited[ny][nx] and arr[ny][nx]!='T':
            dfs(ny, nx, dist+1)

    visited[y][x]=0

r, c, k = map(int, input().split())
arr = [list(input()) for _ in range(r)]

visited = [[0]*c for _ in range(r)]
cnt = 0
dfs(r-1, 0, 1)
print(cnt)