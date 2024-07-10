def make_diff():
    global diff
    start, link = 0, 0
    for i in range(n):
        for j in range(n):
            if visited[i]==0 and visited[j]==0:
                link += arr[i][j]
            elif visited[i]==1 and visited[j]==1:
                start += arr[i][j]
    diff = min(diff, abs(start-link))
    return

def dfs(level):
    if level==n:
        make_diff()
        return
    visited[level] = 1
    dfs(level+1)
    visited[level] = 0
    dfs(level+1)

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [0] * n
diff = 1e9

dfs(0)
print(diff)