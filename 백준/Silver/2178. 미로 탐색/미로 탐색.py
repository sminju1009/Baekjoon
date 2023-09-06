from collections import deque

n, m = map(int, input().split())
arr = [list(map(int, input())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]  # 방문 여부를 저장하는 배열

def bfs(y, x):
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]

    q = deque()
    q.append((y, x, 1))  # 시작 위치와 이동 횟수를 함께 큐에 저장

    while q:
        y, x, cnt = q.popleft()

        if y == n - 1 and x == m - 1:  # 목적지에 도달한 경우
            return cnt

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < n and 0 <= nx < m and arr[ny][nx] == 1 and not visited[ny][nx]:
                visited[ny][nx] = True
                q.append((ny, nx, cnt + 1))

    return -1  # 도달할 수 없는 경우

result = bfs(0, 0)
print(result)
