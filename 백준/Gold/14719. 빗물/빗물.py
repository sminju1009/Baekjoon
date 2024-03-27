h, w = map(int, input().split())
arr = list(map(int, input().split()))

answer = 0

for i in range(1, w-1):
    left = max(arr[:i])
    right = max(arr[i+1:])
    m = min(left, right)
    if m>arr[i]:
        answer += m-arr[i]

print(answer)