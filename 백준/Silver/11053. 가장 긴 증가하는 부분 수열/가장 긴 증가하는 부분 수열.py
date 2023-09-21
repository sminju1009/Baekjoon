n = int(input())
arr = list(map(int, input().split()))

result = [1]*n

for i in range(n):
    a = arr[i]          # 기준점
    for j in range(i):
        b = arr[j]      # 비교 대상
        if a>b:
            result[i] = max(result[j]+1, result[i])

print(max(result))