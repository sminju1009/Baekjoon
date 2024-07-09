def dfs(level):
    global s, b, diff
     # 쓴맛과 신맛의 차이
    if level==n:
        return diff
    for i in range(n):
        if visited[i] ==0:
            s *= tastes[i][0]
            b += tastes[i][1]
            visited[i] = 1
            diff = min(diff, abs(s-b))
            dfs(level+1)
            visited[i] = 0
            s //= tastes[i][0]
            b -= tastes[i][1]

n = int(input())
tastes = []
for _ in range(n):
    tastes.append(list(map(int, input().split())))

s, b = 1, 0    # 신맛, 쓴맛
diff = 1e9
visited = [0] * n

dfs(0)
print(diff)