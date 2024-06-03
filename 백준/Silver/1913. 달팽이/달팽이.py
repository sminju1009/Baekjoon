n = int(input())
arr = [[0]*n for _ in range(n)]
visited = [[0]*n for _ in range(n)]
m = int(input())

y, x = n//2, n//2
# 방향 = 0은 상, 1은 우, 2는 하, 3은 좌
dir = 0
cnt = 1
dir_y = [-1, 0, 1, 0]
dir_x = [0, 1, 0, -1]

change = [2]
for i in range(1, (n-1)*2):
    change.append(change[i-1]+i//2+1)

for i in range(1, n*n+1):
    arr[y][x] = cnt
    visited[y][x] = 1
    cnt+=1

    if i in change:
        dir = (dir+1)%4

    y += dir_y[dir]
    x += dir_x[dir]

# 배열 출력
for i in arr:
    print(*i)

# 숫자 찾기
for i in range(n):
    for j in range(n):
        if arr[i][j]==m:
            print(i+1, j+1)
            break