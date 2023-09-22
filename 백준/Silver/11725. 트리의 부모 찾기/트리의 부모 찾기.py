# 참조 풀이 https://campkim.tistory.com/13

from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
visited = [0]*(n+1)
answer = [0]*(n+1)
arr = [[] for _ in range(n+1)]
for i in range(n-1):
    s, d = map(int, input().split())
    arr[s].append(d)
    arr[d].append(s)

def bfs(arr, v, visited):
    q = deque([v])
    visited[v] = 1
    while q:
        x = q.popleft()
        for i in arr[x]:
            if visited[i]==0:
                answer[i] = x
                q.append(i)
                visited[i] = 1

bfs(arr, 1, visited)

for i in range(2, n+1):
    print(answer[i])