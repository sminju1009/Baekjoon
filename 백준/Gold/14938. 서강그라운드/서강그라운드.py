import heapq

def dijkstra(start):
    heap = []
    heapq.heappush(heap, (0, start))
    res[start][start] = 0

    while heap:
        sk, k = heapq.heappop(heap)
        if sk>res[start][k]:
            continue
        for i in arr[k]:
            cost = sk+i[1]
            if cost<res[start][i[0]]:
                res[start][i[0]] = cost
                heapq.heappush(heap, (cost, i[0]))

n, m, r = map(int, input().split())
items = list(map(int, input().split()))
arr = [[]*n for _ in range(n)]
for _ in range(r):
    a, b, c = map(int, input().split())
    arr[a-1].append((b-1, c))
    arr[b-1].append((a-1, c))

inf = int(21e8)
res = [[inf]*n for _ in range(n)]

for i in range(n):
    dijkstra(i)

ans = [0]*n
for i in range(n):
    for j in range(n):
        if res[i][j]<=m:
            ans[i] += items[j]

print(max(ans))