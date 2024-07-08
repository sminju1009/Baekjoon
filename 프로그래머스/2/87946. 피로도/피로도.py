def solution(k, dungeons):
    def dfs(a, visited):
        nonlocal answer
        for i in range(len(dungeons)):
            if not visited[i] and a >= dungeons[i][0]:
                visited[i] = 1
                dfs(a - dungeons[i][1], visited)
                visited[i] = 0
        answer = max(answer, sum(visited))

    n = len(dungeons)
    visited = [0] * n
    answer = 0
    dfs(k, visited)
    return answer