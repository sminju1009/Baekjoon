T = int(input())
for i in range(T):
    x, y = map(int, input().split())
    ans = y - x

    n = 0
    while True:
        if ans <= n*(n+1):
            break
        n += 1

    if ans>n**2:
        print(2*n)
    else:
        print(2*n-1)