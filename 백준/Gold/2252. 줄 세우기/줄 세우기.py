from collections import deque

n, m = map(int, input().split())

acc = [0] * n

# 인접 리스트에 등록하기
arr = [[] for _ in range(n)]
for k in range(m):
    a, b=map(int, input().split())
    arr[a-1].append(b-1)
    acc[b-1] += 1

q = deque()
# 당장 사전작업 없이 착수할 수 있는 것 넣어주기
for i in range(n):
    if acc[i]==0:
        q.append(i)

while q:
    now = q.popleft()
    print(now+1, end=" ")
    for i in arr[now]:
        if acc[i]==1:
            q.append(i)
        acc[i] -= 1