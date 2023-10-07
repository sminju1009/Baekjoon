# 문어박사님 풀이

from collections import deque
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

def bfs(si, sj, h):
    q = deque()

    q.append((si, sj))
    v[si][sj] = 1

    while q:
        ci, cj = q.popleft()
        # 네 방향 범위 내 미방문, >h인 경우
        for di, dj in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            ni, nj = ci+di, cj+dj
            if 0<=ni<n and 0<=nj<n and v[ni][nj]==0 and arr[ni][nj]>h:
                q.append((ni, nj))
                v[ni][nj] = 1

def solve(h):       # h 높이에 대해 잠기지 않는 영역 개수 리턴
    cnt = 0
    for i in range(n):
        for j in range(n):
            if v[i][j]==0 and arr[i][j]>h:
                bfs(i, j, h)
                cnt += 1
    return cnt

ans = 0
for h in range(100):    # 높이 0~99까지 물 높이 지정
    v = [[0]*n for _ in range(n)]
    ans = max(ans, solve(h))
print(ans)