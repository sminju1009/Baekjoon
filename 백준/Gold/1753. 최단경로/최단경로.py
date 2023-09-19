# 백준 1753 최단경로
import heapq

V, E = map(int, input().split())        # 정점의 개수, 간선의 개수
k = int(input())                        # 시작 정점의 번호(start)
k = k-1
arr = [[] for _ in range(V)]
for _ in range(E):
    u, v, w=map(int, input().split())       # 출발점, 도착점, 가중치
    u, v = u-1, v-1
    arr[u].append((v, w))

inf = 21e8
result = [inf]*V

def dijkstra(start):
    heap = []
    heapq.heappush(heap, (0, start))
    result[start] = 0

    while heap:
        sk, c = heapq.heappop(heap)
        if sk>result[c]:
            continue
        for i in arr[c]:
            cost = sk+i[1]
            if cost<result[i[0]]:
                result[i[0]]=cost
                heapq.heappush(heap, (cost, i[0]))

dijkstra(k)
for i in range(V):
    if k==i:
        print(0)
    elif result[i]==inf:
        print('INF')
    else:
        print(result[i])
