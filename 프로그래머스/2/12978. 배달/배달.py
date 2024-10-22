import heapq

def solution(N, road, K):
    answer = 0
    def dijkstra(start):
        heap = []
        heapq.heappush(heap, (0, start))
        dist[start] = 0
        
        while heap:
            sk, k = heapq.heappop(heap)
            
            if sk>dist[k]:
                continue
            for i in arr[k]:
                cost = sk+i[1]
                if cost<dist[i[0]]:
                    dist[i[0]] = cost
                    heapq.heappush(heap, (cost, i[0]))
                    
    inf = int(21e9)
    dist = [inf] * (N+1)
    arr = [[] for _ in range(N+1)]
    
    for i, j, k in road:
        arr[i].append((j, k))
        arr[j].append((i, k))
    
    dijkstra(1)

    for i in range(1, len(dist)):
        if dist[i]<=K:
            answer += 1
    
    return answer