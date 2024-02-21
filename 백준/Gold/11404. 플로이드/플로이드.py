import heapq

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


n = int(input())
m = int(input())
arr = [[]*(n) for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    arr[a-1].append((b-1, c))

for i in range(n):
    inf = int(21e8)
    result = [inf] * (n)
    dijkstra(i)
    # 도착할 수 없는 경우 0 출력하게 값 수정하기
    for j in range(n):
        if result[j] == inf:
            result[j] = 0
    print(*result)