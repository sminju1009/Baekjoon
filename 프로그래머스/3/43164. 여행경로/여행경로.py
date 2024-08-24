def solution(tickets):
    n = len(tickets)
    visited = [0] * n

    tickets.sort()

    def dfs(level, array):
        if level == n:
            return array
        for i in range(n):
            if not visited[i] and tickets[i][0] == array[-1]:
                visited[i] = 1
                result = dfs(level + 1, array + [tickets[i][1]])
                if result: 
                    return result
                visited[i] = 0
        return None
    
    answer = dfs(0, ["ICN"])
    
    return answer