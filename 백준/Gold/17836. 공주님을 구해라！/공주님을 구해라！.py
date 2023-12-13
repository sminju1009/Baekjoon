from collections import deque

def bfs(sy, sx, ey, ex, array):
    visited = [[0]*m for _ in range(n)]
    q = deque()
    q.append((sy, sx, 0))
    visited[sy][sx] = 1

    while q:
        y, x, time = q.popleft()
        for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            ny, nx = dy+y, dx+x
            if 0<=ny<n and 0<=nx<m and visited[ny][nx]==0 and array[ny][nx]!=1:
                q.append((ny, nx, time+1))
                visited[ny][nx]=1
                if ny==ey and nx==ex:
                    return time+1

    # 만나지 못할 때 반환할 숫자
    return 21e6

# 성의 크기 세로 n, 가로 m / 저주의 제한 시간인 정수 t
n, m, t = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
# 그람을 만나고 나서 사용할 배열
arr_no = [[0]*m for _ in range(n)]

# 그람이 있는 곳의 좌표 설정하기
gy, gx = 0, 0
for i in range(n):
    for j in range(m):
        if arr[i][j]==2:
            gy, gx = i, j

# bfs 작동하기
# res1 = 그람이 없을 때
res1 = bfs(0, 0, n-1, m-1, arr)
# res2 = 그람이 있을 때
res2 = bfs(0, 0, gy, gx, arr) + bfs(gy, gx, n-1, m-1, arr_no)

# 정답 도출하기
res = min(res1, res2)
if res>t:
    print('Fail')
else:
    print(res)