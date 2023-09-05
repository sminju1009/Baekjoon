import sys
from collections import deque

input = sys.stdin.readline

# 입력값 받는 부분
n = int(input())
s, e = map(int, input().split())
m = int(input())
graph = [[] for _ in range(n + 1)]
visited = [-1] * (n + 1)  # -1로 초기화합니다.
result = []

# 어떤 노드들이 연결되어 있는지 graph라는 2차원 배열에 저장
for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

def bfs(num):
    q = deque()
    q.append(num)
    visited[num] = 0  # 시작 노드의 방문 여부를 0으로 설정합니다.
    while q:
        num = q.popleft()
        for n in graph[num]:
            if visited[n] == -1:
                visited[n] = visited[num] + 1
                q.append(n)

bfs(s)
if visited[e] >= 0:
    print(visited[e])
else:
    print(-1)
