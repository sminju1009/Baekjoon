from collections import deque
n, m = map(int, input().split())
q = deque([i for i in range(1, n+1)])
arr = list(map(int, input().split()))

cnt = 0
for num in arr:
    while 1:
        if q[0]==num:
            q.popleft()
            break
        else:
            if q.index(num) <= len(q) //2:
                q.rotate(-1)
                cnt += 1
            else:
                q.rotate(1)
                cnt += 1
                
print(cnt)