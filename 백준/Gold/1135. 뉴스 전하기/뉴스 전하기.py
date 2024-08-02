def dfs(here):
    temp = []
    for slave in tree[here]:
        dfs(slave)
        temp.append(dp[slave])

    if temp:
        temp.sort(reverse=True)
        next_time = [temp[i] + i + 1 for i in range(len(temp))]
        dp[here] = max(next_time)

n = int(input())
arr = list(map(int, input().split()))

# 트리
tree = [[] for _ in range(n)]
# 부모-자식 관계 성립하게 대입하기
for i in range(1, n):
    tree[arr[i]].append(i)

dp = [0 for _ in range(n)]

dfs(0)
print(dp[0])