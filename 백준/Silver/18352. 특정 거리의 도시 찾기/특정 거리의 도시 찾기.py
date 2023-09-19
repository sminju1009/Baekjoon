# 백준 18352번 특정 거리의 도시 찾기

import heapq

n, m, k, x = map(int, input().split())      # 도시 개수, 도로 개수, 최단 거리, 출발 도시 번호
x = x-1
arr = [[] for _ in range(n)]
for _ in range(m):
    a, b=map(int, input().split())          # 단방향 도로가 존재한다는 의미
    a, b = a-1, b-1
    arr[a].append((b, 1))       # k는 거리

inf = 21e8
result = [inf]*n

def dijkstra(start):
    cnt = []
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
                result[i[0]] = cost
                heapq.heappush(heap, (cost, i[0]))
    for i in range(n):
        if result[i]==k:
            cnt.append(i+1)
    return cnt

ans = dijkstra(x)
if ans==[]:
    print(-1)
else:
    print(*ans, sep='\n')