def fibo(n):
    if n == 0:
        return 0
    
    dp = [0, 1]
    
    for i in range(2, abs(n) + 1):
        dp.append((dp[i - 1] + dp[i - 2]) % 1000000000)
    
    if n < 0 and n % 2 == 0:
        return -dp[abs(n)]
    else:
        return dp[abs(n)]

n = int(input())
result = fibo(n)

if result > 0:
    print(1)
elif result < 0:
    print(-1)
else:
    print(0)

print(abs(result))