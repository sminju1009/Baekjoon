from collections import deque, defaultdict

def bfs(y, x):
    q = deque()
    q.append((y, x))
    visited[y][x] = 1
    cnt = 1

    while q:
        y, x = q.popleft()
        
        # 현재 방에서 켤 수 있는 불 다 켜기
        for b, a in switch_on[(y, x)]:
            if on[b][a] == 0:
                on[b][a] = 1
                cnt += 1
                # 켠 방이 인접한 방 중 이미 방문한 방이 있으면 큐에 넣기
                for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
                    ny, nx = b + dy, a + dx
                    if 0 <= ny < n and 0 <= nx < n and visited[ny][nx]:
                        q.append((b, a))
                        break

        # 인접한 방 탐색
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = y + dy, x + dx
            if 0 <= ny < n and 0 <= nx < n and not visited[ny][nx] and on[ny][nx]:
                visited[ny][nx] = 1
                q.append((ny, nx))

        # 불이 켜졌지만 방문하지 않은 방들을 큐에 추가
        for b in range(n):
            for a in range(n):
                if on[b][a] == 1 and not visited[b][a]:
                    for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
                        ny, nx = b + dy, a + dx
                        if 0 <= ny < n and 0 <= nx < n and visited[ny][nx]:
                            visited[b][a] = 1
                            q.append((b, a))
                            break

    return cnt

n, m = map(int, input().split())
on = [[0] * n for _ in range(n)]
on[0][0] = 1 # 시작 방의 불은 켜져 있음
visited = [[0] * n for _ in range(n)]

switch_on = defaultdict(list) # 각 방에서 켤 수 있는 스위치를 저장

for _ in range(m):
    y, x, b, a = map(int, input().split())
    switch_on[(y-1, x-1)].append((b-1, a-1))

ans = bfs(0, 0)
print(ans)