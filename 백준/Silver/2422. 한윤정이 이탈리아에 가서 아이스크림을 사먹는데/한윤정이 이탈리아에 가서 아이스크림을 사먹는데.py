from collections import defaultdict

n, m = map(int, input().split())
arr = defaultdict(list)
for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

cnt = 0


for i in range(1, n-1):
    flag = 0
    for j in range(i+1, n):
        if j in arr[i]:
            flag = 1
        for k in range(j+1, n+1):
            if j in arr[i] or k in arr[j] or k in arr[i]:
                flag = 1
            else:
                flag = 0
            if flag==0:
                cnt += 1

print(cnt)