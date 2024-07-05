def dfs(y, x, number):
    if len(number)==6:
        if number not in result:
            result.append(number)
        return

    for dy, dx in ((0, -1), (-1, 0), (0, 1), (1, 0)):
        ny, nx = dy+y, dx+x
        if 0<=ny<5 and 0<=nx<5:
            dfs(ny, nx, number + arr[ny][nx])

arr = []
for _ in range(5):
    nums = list(input().split())
    arr.append(nums)

result = []

for i in range(5):
    for j in range(5):
        dfs(i, j, arr[i][j])

print(len(result))