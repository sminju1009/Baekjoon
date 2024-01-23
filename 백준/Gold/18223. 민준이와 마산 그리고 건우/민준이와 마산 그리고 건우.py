import heapq

def dijkstra(start, result):
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


# 정점의 개수 v, 간선의 개수 e, 건우가 위치한 정점 p
v, e, p = map(int, input().split())
arr = [[] for _ in range(v+1)]
for _ in range(e):
    a, b, c = map(int, input().split())
    arr[a].append((b, c))
    arr[b].append((a, c))

inf = int(21e8)
result1 = [inf]*(v+1)
result2 = [inf]*(v+1)

dijkstra(1, result1)
dijkstra(p, result2)

if result1[-1]==result1[p]+result2[-1]:
    print("SAVE HIM")
else:
    print("GOOD BYE")