import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(int(input()))

start, end = 1, max(arr)*m
result = 0

while start<=end:
    mid = (start+end)//2

    level = 0
    for i in range(n):
        level += mid//arr[i]

    if level>=m:
        end = mid-1
        result = mid
    else:
        start = mid+1

print(result)