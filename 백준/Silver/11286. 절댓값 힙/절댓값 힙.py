import heapq
import sys
input = sys.stdin.readline

n = int(input())

heap = []

for _ in range(n):
    a = int(input())
    if a==0:
        if not heap:
            print(0)
        else:
            print(heapq.heappop(heap)[1])
    else:
        heapq.heappush(heap, (abs(a), a))