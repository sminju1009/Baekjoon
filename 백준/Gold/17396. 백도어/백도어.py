import heapq

n, m = map(int, input().split())
lst = list(map(int, input().split()))
lst[-1] = 0
arr = [[] for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    arr[a].append((b, c))
    arr[b].append((a, c))

inf = int(100000 * 100000 + 1)
result = [inf]*n

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
            if cost<result[i[0]] and lst[i[0]] == 0:
                result[i[0]] = cost
                heapq.heappush(heap, (cost, i[0]))

dijkstra(0)
if result[-1]==inf:
    print(-1)
else:
    print(result[-1])