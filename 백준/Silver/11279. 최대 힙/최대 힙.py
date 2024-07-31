import sys
input = sys.stdin.readline
from heapq import heappop, heappush

n = int(input())
heap = []
for _ in range(n):
    a = int(input())
    if a>0:
        heappush(heap, (-a, a))
    else:
        if heap:
            print(heappop(heap)[1])
        else:
            print(0)