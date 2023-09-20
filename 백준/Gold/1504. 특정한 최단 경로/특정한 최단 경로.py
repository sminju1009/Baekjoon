# 참고 페이지
# https://velog.io/@ledcost/%EB%B0%B1%EC%A4%80-1504-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%ED%8A%B9%EC%A0%95%ED%95%9C-%EC%B5%9C%EB%8B%A8-%EA%B2%BD%EB%A1%9C-%EA%B3%A8%EB%93%9C4-%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BC
import heapq
import sys
input = sys.stdin.readline


n, e = map(int, input().split())    # 정점의 개수, 간선의 개수
arr = [[] for _ in range(n)]
for _ in range(e):
    a, b, c = map(int, input().split())
    a, b = a-1, b-1
    arr[a].append((b, c))
    arr[b].append((a, c))
v1, v2 = map(int, input().split())
v1, v2 = v1-1, v2-1

inf = int(21e8)

def dijkstra(start, end):
    result = [inf] * n
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
    return result[end]

route1 = dijkstra(0, v1)+dijkstra(v1, v2)+dijkstra(v2, n-1)
route2 = dijkstra(0, v2)+dijkstra(v2, v1)+dijkstra(v1, n-1)

if route1>=inf or route2>=inf:
    print(-1)
else:
    print(min(route1, route2))