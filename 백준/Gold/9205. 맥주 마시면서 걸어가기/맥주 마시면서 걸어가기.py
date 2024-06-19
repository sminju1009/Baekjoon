from collections import deque

t = int(input()) # 테스트 케이스
for _ in range(t):
    n = int(input()) # 맥주를 파는 편의점의 갯수
    start_y, start_x = map(int, input().split())
    convenience = [] # 편의점 좌표를 담을 곳
    for _ in range(n):
        convenience.append(list(map(int, input().split())))
    end_y, end_x = map(int, input().split()) # 락 페스티벌 좌표

    visited = [0] * (n+1) # home은 visited 배열 넣지 않음

    q = deque()
    q.append((start_y, start_x))

    flag = 1 # 0은 happy, 1은 sad

    while q:
        y, x = q.popleft()
        if abs(y-end_y)+abs(x-end_x)<=1000:
            flag = 0
        for i in range(n):
            if not visited[i]:
                ny, nx = convenience[i]
                if abs(y-ny)+abs(x-nx)<=1000:
                    visited[i] = 1
                    q.append((ny, nx))

    if flag==1:
        print("sad")
    elif flag==0:
        print("happy")