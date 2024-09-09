def dfs(level, idx, start_team):
    global res
    if level == n // 2:
        link_team = [i for i in range(n) if i not in start_team]
        
        start_score, link_score = 0, 0
        for i in range(n // 2):
            for j in range(n // 2):
                start_score += arr[start_team[i]][start_team[j]]
                link_score += arr[link_team[i]][link_team[j]]
                
        res = min(res, abs(start_score - link_score))
        return
    
    for i in range(idx, n):
        dfs(level + 1, i + 1, start_team + [i])

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

res = float('inf')
dfs(0, 0, [])
print(res)