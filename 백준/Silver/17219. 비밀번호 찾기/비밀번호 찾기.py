from collections import defaultdict

n, m = map(int, input().split())
arr = defaultdict(list)
for _ in range(n):
    a, b = input().split()
    arr[a].append(b)

for _ in range(m):
    a = input()
    b = ''.join(arr[a])
    print(b)