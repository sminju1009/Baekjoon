n = int(input())
arr = [[] for _ in range(n)]
for i in range(n):
    arr[i] = list(input())

lst = list(arr[0])

for i in range(1, n):
    for j in range(len(arr[0])):
        if arr[i][j]!=arr[0][j]:
            lst[j] = '?'

print(*lst, sep="")