from collections import deque

n = int(input())
q = deque()
q.append([n])
ans = []

while q:
    y = q.popleft()
    x = y[0]
    if x==1:
        ans = y
        break

    if x%3==0:
        q.append([x//3] + y)

    if x%2==0:
        q.append([x//2] + y)

    q.append([x-1] + y)

print(len(ans)-1)
print(*ans[::-1])