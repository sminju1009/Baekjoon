from collections import deque

def bfs():
    global min_path, cnt
    q = deque()
    q.append(n)
    visited[n] = 1

    while q:
        y = q.popleft()
        if y==k:
            min_path = visited[y]
            cnt += 1
            continue

        for dy in (2*y, y-1, y+1):
            if 0<=dy<100001 and (visited[dy]==0 or visited[dy]==visited[y]+1):
                visited[dy] = visited[y] + 1
                q.append(dy)

n, k = map(int, input().split())
visited = [0] * 100001

cnt = 0  # 최적 경로 수
min_path = 0  # 최소 시간
bfs()

print(min_path-1)
print(cnt)