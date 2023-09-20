# 동전 2 - 강사님 코드

n, k = map(int, input().split())
coin = [0]
for i in range(n):
    don = int(input())
    coin.append(don)

arr = [[10001]*(k+1) for _ in range(n+1)]

arr[0][0] = 0

coin.sort()

for i in range(1, n+1):
    for j in range(1, k+1):
        mok = j//coin[i]
        if j%coin[i]==0:
            arr[i][j] = mok
        else:
            if mok==0:
                arr[i][j] = arr[i-1][j]
            else:
                arr[i][j] = min(arr[i-1][j], arr[i][j-coin[i]]+1)

if arr[n][k]>=10001:
    print(-1)
else:
    print(arr[n][k])