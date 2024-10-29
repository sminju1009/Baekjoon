n, t = map(int, input().split())
knapsack = [[0]*(t+1) for _ in range(n+1)]
arr = [[0, 0]]
for _ in range(n):
    k, s = map(int, input().split())
    arr.append([k, s])

for i in range(1, n+1):
    for j in range(1, t+1):
        w = arr[i][0]
        value = arr[i][1]
        if j<w:
            knapsack[i][j] = knapsack[i-1][j]
        else:
            knapsack[i][j] = max(knapsack[i-1][j], value+knapsack[i-1][j-w])

print(knapsack[n][t])