n, a, d = map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0
temp = a
for i in range(n):
    if arr[i]==temp:
        cnt += 1
        temp += d

print(cnt)