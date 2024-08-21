from collections import deque

def solution(n, computers):
    answer = 0
    arr = [[] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1 and i != j:
                arr[i].append(j)

    visited = [0] * n

    def bfs(num):
        q = deque()
        q.append(num)
        visited[num] = 1

        while q:
            y = q.popleft()
            for x in arr[y]:
                if not visited[x]:
                    visited[x] = 1
                    q.append(x)

    for i in range(n):
        if not visited[i]:
            bfs(i)
            answer += 1

    for i in range(n):
        if not visited[i]:
            answer += 1
    return answer