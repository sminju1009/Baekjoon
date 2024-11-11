n, m = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(int(input()))

start, end = 1, max(arr)*m
people = [0] * n
result = 0

while start<=end:
    mid = (start+end)//2

    for i in range(n):
        people[i] = mid//arr[i]
    level = sum(people)

    if level>=m:
        end = mid-1
        result = mid
    else:
        start = mid+1

print(result)