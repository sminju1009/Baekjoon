n = int(input())

dp = [[1] * 3 for _ in range(n)]

for i in range(1, n):
    dp[i][0] = sum(dp[i-1]) % 9901
    dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901
    dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901

print(sum(dp[-1]) % 9901)