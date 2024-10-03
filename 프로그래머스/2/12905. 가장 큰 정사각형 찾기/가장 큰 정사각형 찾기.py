import sys

def solution(board):    
    n = len(board)
    m = len(board[0])
    dp = [[-1]*m for _ in range(n)]
    
    for i in range(n):
        for j in range(m):
            if board[i][j]==1:
                flag = True
                for dy, dx in ((0, -1), (-1, 0), (-1, -1)):
                    if i+dy < 0 or j+dx < 0:
                        flag = False
                        dp[i][j] = 1
                        break
                    if board[i+dy][j+dx]==0:
                        dp[i][j]=1
                        flag = False
                        break
                if flag:
                    mini = sys.maxsize
                    for dy, dx in ((0, -1), (-1, 0), (-1, -1)):
                        if mini>dp[i+dy][j+dx]:
                            mini = dp[i+dy][j+dx]
                    dp[i][j] = mini+1
    
    maxlen = 0
    for i in range(n):
        for j in range(m):
            if dp[i][j]>maxlen:
                maxlen = dp[i][j]
                
    return maxlen**2