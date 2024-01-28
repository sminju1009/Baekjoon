# 투 포인터

n = int(input())
m = int(input()) # target
arr = list(map(int, input().split()))
arr.sort()

start = 0
end = n-1
cnt = 0

while start<end:
    sum_num = arr[start] + arr[end]
    if sum_num < m:
        start += 1
    elif sum_num > m:
        end -= 1
    else:
        cnt += 1
        start += 1
        end -= 1
        
print(cnt)