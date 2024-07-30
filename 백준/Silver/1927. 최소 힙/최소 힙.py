import sys
input = sys.stdin.readline
from heapq import heappush, heappop

n = int(input())
heap = []
for _ in range(n):
    a = int(input())
    if a>0:
        heappush(heap, a)
    else:
        if heap:
            print(heappop(heap))
        else:
            print(0)