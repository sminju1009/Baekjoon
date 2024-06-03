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
                visited[i[0]] = k
                heapq.heappush(heap, (cost, i[0]))


n = int(input())
m = int(input())
arr = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    arr[a].append((b, c))
start, fin = map(int, input().split())

inf = int(21e10)
result = [inf] * (n+1)
visited = [0] * (n+1)
dijkstra(start)

ans = []
tmp = fin
while tmp != start:
    ans.append(str(tmp))
    tmp = visited[tmp]

ans.append(str(start))
ans.reverse()

print(result[fin])
print(len(ans))
print(" ".join(ans))