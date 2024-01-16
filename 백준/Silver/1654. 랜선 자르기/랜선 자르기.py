k, n = map(int, input().split())
arr = [int(input()) for _ in range(k)]

start, end = 1, max(arr)

while end>=start:
    mid = (start + end) // 2
    cnt = 0
    for i in arr:
        cnt += i//mid

    if cnt>=n:
        start = mid+1
    elif cnt<n:
        end = mid-1

print(end)