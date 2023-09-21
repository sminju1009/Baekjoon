# 백준 1012 유기농 배추 - 뤼튼이 짜준 코드
from collections import deque

# k에서 인접한 만큼 빼는 방식을 이용하는 것은 어떨까?
def bfs():
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    cnt = 0
    q = deque()

    for i in range(m):
        for j in range(n):
            if arr[i][j] == 1:
                q.append((i, j))
                arr[i][j] = 0
                cnt += 1

                while q:
                    y, x = q.popleft()
                    for l in range(4):
                        ny = dy[l] + y
                        nx = dx[l] + x
                        if 0 <= ny < m and 0 <= nx < n:
                            if arr[ny][nx] == 1:
                                arr[ny][nx] = 0
                                q.append((ny, nx))

    return cnt

T = int(input())
for tc in range(T):
    m, n, k = map(int, input().split())  # m을 세로, n을 가로로 바꿈!
    arr = [[0] * n for _ in range(m)]
    for _ in range(k):
        x, y = map(int, input().split())
        x, y = y, x
        arr[y][x] = 1

    print(bfs())
