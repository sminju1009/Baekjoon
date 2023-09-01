n = int(input())
arr = [list(map(int, input())) for _ in range(n)]
homes = []          # 단지별 집의 수를 담을 임시 리스트
house = 0           # 단지별로 속하는 집의 수

# dfs로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
def dfs(y, x):
    global house
    # 주어진 범위를 벗어나는 경우에는 즉시 종료
    if y<0 or x<0 or y>=n or x>=n:
        return False
    # 현재 노드를 아직 방문하지 않았다면
    if arr[y][x]==1:
        house += 1
    # 해당 노드 방문 처리
        arr[y][x]=0
    # 상하좌우 위치도 모두 재귀적으로 호출
        dfs(y-1, x)
        dfs(y, x-1)
        dfs(y+1, x)
        dfs(y, x+1)
        return True
    return False

# 모든 노드에 대해 cnt 채우기
cnt = 0

for i in range(n):
    for j in range(n):
        # 현재 위치에서 dfs 수행
        if dfs(i, j)==True:
            cnt += 1
            homes.append(house)
            house = 0

homes.sort()
print(cnt)
for i in homes:
    print(i)