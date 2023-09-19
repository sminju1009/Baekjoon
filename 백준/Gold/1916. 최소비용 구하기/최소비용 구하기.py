import heapq

n = int(input())    # 도시의 개수
m = int(input())    # 버스의 개수
arr = [[] for _ in range(n)]
for _ in range(m):
    s, e, c = map(int, input().split()) # 출발도시번호, 도착도시번호, 비용
    s, e = s-1, e-1
    arr[s].append((e, c))
start, end = map(int, input().split())
start, end = start-1, end-1

inf = 21e8
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
            cost = sk+i[1]
            if cost<result[i[0]]:
                result[i[0]] = cost
                heapq.heappush(heap, (cost, i[0]))

dijkstra(start)
print(result[end])