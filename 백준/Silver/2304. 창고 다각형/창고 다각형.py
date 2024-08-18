n = int(input())
arr = []
max_height = 0
max_idx = 0

# 최대 높이, 최대 높이가 나오는 왼쪽 면의 위치 찾기
for i in range(n):
    l, h = map(int, input().split())
    arr.append((l, h))
    if max_height<h:
        max_height = h
        max_idx_dot = l

# arr 정렬하기
arr.sort(key=lambda x:x[0])

# 좌-우 분기점 찾기
for i in range(len(arr)):
    if arr[i][0]==max_idx_dot:
        max_idx = i
        break


area = 0 # 면적
# 왼쪽
now_max_left = arr[0][1]

for i in range(max_idx):
    if now_max_left<arr[i][1]:
        now_max_left = arr[i][1]
    area += (arr[i+1][0] - arr[i][0])*now_max_left

area += max_height


# 오른쪽
now_max_right = arr[-1][1]

for i in range(n-1, max_idx, -1):
    if now_max_right<arr[i][1]:
        now_max_right = arr[i][1]
    area += (arr[i][0] - arr[i-1][0])*now_max_right

print(area)