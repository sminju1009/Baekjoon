n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

for i in range(n):
    cnt = 1
    for j in range(n):
        if i!=j and arr[i][0]<arr[j][0] and arr[i][1]<arr[j][1]:
            cnt += 1
    print(cnt, end=" ")