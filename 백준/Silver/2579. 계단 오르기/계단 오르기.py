# m

n = int(input())
lst = [0] + [int(input()) for _ in range(n)]

# dp테이블 생성 및 초기화
dp = [[0]*3 for _ in range(n+1)]
for i in range(1, n+1):
    # 안 밟는 경우
    dp[i][0] = max(dp[i-1][1], dp[i-1][2])
    # 직전에 밟은 경우
    dp[i][1] = dp[i-1][0]+lst[i]
    # 직전에 두 번 연속 밟은 경우
    dp[i][2] = dp[i-1][1]+lst[i]

print(max(dp[n][1:3]))