def dfs(level, temp):
    global maxi
    if level==11:
        maxi = max(temp, maxi)
        return
    for j, k in possible[level]:
        if not visited[j]:
            visited[j] = 1
            dfs(level + 1, temp + k)
            visited[j] = 0

T = int(input())
for _ in range(T):
    arr = [list(map(int, input().split())) for _ in range(11)]
    possible = [[] for _ in range(11)]
    for i in range(11):
        for j in range(11):
            if arr[i][j]!=0:
                possible[i].append((j, arr[i][j]))

    maxi = 0
    visited = [0] * 11
    player = [0] * 11
    dfs(0, 0)
    print(maxi)