n = int(input())
n = 1000-n

cnt = 0
arr = [500, 100, 50, 10, 5, 1]
for i in range(len(arr)):
    cnt += n//arr[i]
    n = n%arr[i]

print(cnt)