import sys
input = sys.stdin.readline

def dfs(y, x, cnt):
    global max_cnt
    max_cnt = max(max_cnt, cnt)
    
    for dy, dx in directions:
        ny, nx = y + dy, x + dx
        if 0 <= ny < R and 0 <= nx < C:
            next_char = board[ny][nx]
            if next_char not in visited:
                visited.add(next_char)
                dfs(ny, nx, cnt + 1)
                visited.remove(next_char)

R, C = map(int, input().split())
board = [input().strip() for _ in range(R)]

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
visited = set(board[0][0])
max_cnt = 1

dfs(0, 0, 1)
print(max_cnt)