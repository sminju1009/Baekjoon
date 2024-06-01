n, m = map(int, input().split())

dp = [1] * (n+1)
for i in range(2, n+1):
    dp[i] = i * dp[i-1]

ans = dp[n] // (dp[m]* dp[n-m])
print(ans%10007)