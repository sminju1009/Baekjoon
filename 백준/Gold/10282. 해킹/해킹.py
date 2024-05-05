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


T = int(input())
for tc in range(T):
    # n 컴퓨터 갯수, d 의존성 갯수, c 해킹당한 컴퓨터 번호
    n, d, c = map(int, input().split())
    arr = [[] for _ in range(n+1)]
    for _ in range(d):
        # a가 b를 의존, b가 감염되면 s초 후 a도 감염
        a, b, s = map(int, input().split())
        arr[b].append((a, s))

    inf = int(21e9)
    result = [inf]*(n+1)

    dijkstra(c)
    cnt = 0
    for i in range(n+1):
        if result[i]==inf:
            result[i] = -1
        else:
            cnt += 1

    print(cnt, max(result))