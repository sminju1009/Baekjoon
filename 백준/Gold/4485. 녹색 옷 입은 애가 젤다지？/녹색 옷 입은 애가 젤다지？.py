import heapq

def dijkstra(y, x):
    heap = []
    heapq.heappush(heap, (arr[0][0], y, x))
    dist[y][x] = 0

    while heap:
        cost, y, x = heapq.heappop(heap)
        if y==n-1 and x==n-1:
            print(f'Problem {count}: {dist[y][x]}')
            break
        for dy, dx in ((0, -1), (0, 1), (1, 0), (-1, 0)):
            ny, nx = dy+y, dx+x
            if 0<=ny<n and 0<=nx<n:
                new_cost = cost + arr[ny][nx]
                if new_cost<dist[ny][nx]:
                    dist[ny][nx] = new_cost
                    heapq.heappush(heap, (new_cost, ny, nx))

count = 1
while True:
    n = int(input())
    if n==0:
        break

    arr = [list(map(int, input().split())) for _ in range(n)]
    inf = int(21e9)
    dist = [[inf]*n for _ in range(n)]

    dijkstra(0, 0)
    count += 1