def solution(m, n, puddles):
    dp = [[0]*m for _ in range(n)]
    for x, y in puddles:
        dp[y-1][x-1] = -1
    
    dp[0][0] = 1
    for i in range(n):
        for j in range(m):
            if i==0 and j==0:
                continue
            if dp[i][j]==-1:
                dp[i][j] = 0
            else:
                if i!=0 and j!=0:
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007
                elif i==0:
                    dp[i][j] = dp[i][j-1]  % 1000000007
                else:
                    dp[i][j] = dp[i-1][j] % 1000000007
                    
    return dp[-1][-1]