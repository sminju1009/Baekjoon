n, m=map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0
e = 0
ans = 0

for s in range(n):
    while ans<m and e<n:
        ans += arr[e]
        e += 1
    if ans==m:
        cnt += 1
    ans -= arr[s]

print(cnt)