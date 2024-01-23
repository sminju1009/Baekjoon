n = int(input())

for _ in range(n):
    a = int(input())
    arr = list(map(int, input().split()))

    print(min(arr), max(arr))