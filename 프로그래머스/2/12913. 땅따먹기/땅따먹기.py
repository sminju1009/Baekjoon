def solution(land):
    answer = 0
    
    n = len(land)
    dp = [[0]*4 for _ in range(n)]
    
    # 첫줄
    for i in range(4):
        dp[0][i] = land[0][i]
        
    # 둘째줄 이후
    for i in range(1, n):
        for j in range(4):
            maxi = 0
            for k in range(4):
                if j!=k:
                    maxi = max(maxi, dp[i-1][k])
            dp[i][j] = maxi+land[i][j]

    for i in range(4):
        answer = max(answer, dp[n-1][i])
    return answer