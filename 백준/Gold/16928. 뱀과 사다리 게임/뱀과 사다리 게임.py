from collections import deque

def bfs(a):
    q = deque([a])
    visited[a] = 1

    while q:
        b = q.popleft()
        # 100번 칸에 도착했다면
        if b==100:
            print(board[b])
            break
        for dice in range(1, 7):
            next = dice + b
            if next <= 100 and visited[next]==0:
                # 이동할 위치에 사다리가 있다면
                if next in ladder.keys():
                    next = ladder[next]
                # 이동할 위치에 뱀이 있다면
                if next in snake.keys():
                    next = snake[next]
                # 이동할 위치에 아무 것도 없다면
                if visited[next]==0:
                    visited[next] = 1
                    board[next] = board[b] + 1
                    q.append(next)

n, m = map(int, input().split())
ladder = dict()
snake = dict()
for _ in range(n):
    i, j = map(int, input().split())
    ladder[i] = j
for _ in range(m):
    i, j = map(int, input().split())
    snake[i] = j

board = [0] * 101
visited = [0] * 101

bfs(1)