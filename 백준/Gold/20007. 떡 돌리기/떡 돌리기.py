import heapq

n, m, x, y = map(int, input().split())
arr = [[] for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    arr[a].append((b, c))
    arr[b].append((a, c))

inf = int(21e8)
result = [inf] * n

def dijkstra(start):
    heap = []
    heapq.heappush(heap, (0, start))
    result[start] = 0

    while heap:
        sk, k = heapq.heappop(heap)

        if sk>result[k]:
            continue

        for i in arr[k]:
            cost = sk + i[1]
            if cost<result[i[0]]:
                result[i[0]] = cost
                heapq.heappush(heap, (cost, i[0]))

dijkstra(y)

for i in range(n):
    # 거리가 너무 먼 경우
    if result[i]>x//2:
        print(-1)
        exit()

result.sort()
ans = 0
day = 1
for i in range(n):
    if (ans + result[i])*2<=x:
        ans = ans + result[i]
    else:
        ans = result[i]
        day += 1

print(day)