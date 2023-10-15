n = int(input())
arr = list(map(int, input().split()))
lst = []

for i in range(2, 1001):
    for j in range(2, 33):
        if i>j and i%j==0:
            lst.append(i)
            break

cnt = 0
for i in range(n):
    if arr[i]!=1 and arr[i] not in lst:
        cnt += 1

print(cnt)