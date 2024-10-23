n, m = map(int, input().split())
arr = list(map(int, input().split()))

start, end = 1, max(arr)

while start<=end:
    mid = (start+end)//2
    log = 0
    for i in arr:
        if i>mid:
            log += i-mid
    if log<m:
        end = mid-1
    else:
         start = mid+1

print(end)