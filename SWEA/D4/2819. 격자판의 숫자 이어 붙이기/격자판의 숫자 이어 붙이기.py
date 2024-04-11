def dfs(y, x, result):
    if 0<=x<4 and 0<=y<4:
        result += arr[y][x]
        if len(result)==7:
            ans.append(result)
            return

        dfs(y, x+1, result)
        dfs(y, x-1, result)
        dfs(y+1, x, result)
        dfs(y-1, x, result)

T = int(input())

for tc in range(1, T+1):
    arr = [list(map(str, input().split())) for _ in range(4)]
    ans = []
    for i in range(4):
        for j in range(4):
            dfs(i, j, '')
    print(f'#{tc} {len(set(ans))}')