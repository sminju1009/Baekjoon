import sys
input = sys.stdin.readline

n, m = map(int, input().split())    # 수 개수 n, 합 구해야 하는 횟수 m
arr = list(map(int, input().split()))   # n개의 수
lst = [0]

cnt = 0
for i in arr:
    cnt += i
    lst.append(cnt)

for i in range(m):
    a, b = map(int, input().split())
    print(lst[b] - lst[a-1])