import heapq

n, d = map(int, input().split())
arr = [[] for _ in range(d+1)]

# 거리를 1로 초기화
for i in range(d):
    arr[i].append((i+1, 1))

# 지름길이 있는 경우에 업데이트
for _ in range(n):
    a, b, c = map(int, input().split())
    if b>d:
        continue
    arr[a].append((b, c))

inf = int(1e9)
result = [inf]*(d+1)

def dijkstra(start):
    heap = []
    heapq.heappush(heap, (0, start))
    result[start] = 0

    while heap:
        sk, k = heapq.heappop(heap)
        if sk>result[k]:
            continue
        for i in arr[k]:
            cost = sk+i[1]
            if cost<result[i[0]]:
                result[i[0]] = cost
                heapq.heappush(heap, (cost, i[0]))

dijkstra(0)
print(result[d])