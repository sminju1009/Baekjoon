m, n = map(int, input().split())
arr = list(map(int, input().split()))

start, end = 1, max(arr)
answer = 0
while start<=end:
    mid = (start+end)//2
    cnt = 0
    for i in arr:
        cnt += i//mid
    if cnt>=m:
        answer = mid
        start = mid+1
    else:
        end = mid-1

print(answer)