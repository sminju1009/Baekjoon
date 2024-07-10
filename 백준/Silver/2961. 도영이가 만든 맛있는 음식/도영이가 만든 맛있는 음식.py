def dfs(level, s, b, selected):
    global diff
    if level == n:
        if selected > 0:
            diff = min(diff, abs(s - b))
        return
    # 현재 재료를 선택하는 경우
    dfs(level + 1, s * tastes[level][0], b + tastes[level][1], selected + 1)
    # 현재 재료를 선택하지 않는 경우
    dfs(level + 1, s, b, selected)

n = int(input())
tastes = [list(map(int, input().split())) for _ in range(n)]

s, b = 1, 0    # 신맛, 쓴맛
diff = 1e9

dfs(0, 1, 0, 0)
print(diff)